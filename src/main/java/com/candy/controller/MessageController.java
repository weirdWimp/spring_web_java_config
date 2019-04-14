package com.candy.controller;

import com.candy.entity.User;
import com.candy.exception.NoUserException;
import com.candy.exception.RegisterException;
import com.candy.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Controller
@RequestMapping(value = "/blog")
public class MessageController {
    private EntityRepository repository;

    @Autowired
    public MessageController(EntityRepository repository) {
        this.repository = repository;
    }

    /**
     * 对类似 /messageList?count=10 的url进行处理
     *
     * @param count
     * @param model
     * @return
     */
    @RequestMapping(value = "/messageList", method = RequestMethod.GET)
    public String message(@RequestParam(value = "count", defaultValue = "20") int count, Model model) {
        model.addAttribute("messageList", repository.getMessageList(count));
        return "message";
    }

    /**
     * 对类似 /messageList/Tom 这样的url进行处理
     *
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/messageList/{name}", method = RequestMethod.GET)
    public String messageListByName(@PathVariable String name, Model model) {
        model.addAttribute("messageList", repository.getMessageListByName(name));
        return "message";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistration(Model model) {
        User user = new User("gph1993@163.com", "Jason", "Guo", "weirdwimp", "123456");
        model.addAttribute(user);
        return "registerFormSpringForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> printError(error));
            return "registerFormSpringForm";
        }
        System.out.println("--------" + user.getUsername());
        repository.saveUser(user);
        return "redirect:/blog/" + user.getUsername();
    }

    @RequestMapping(value = "/register/multipart", method = RequestMethod.GET)
    public String showRegistrationMultipart(Model model) {
        model.addAttribute(new User());
        return "registerForm";
    }


    /**
     * 简单的表单不支持文件上传，Multipart 是支持的，表单中的每个域对应一个part，但是需要一个 MultipartResolver
     * 的实现类来解析 Multipart 请求，Spring 中有一个默认实现 StandardServletMultipartResolver，是基于 java servlet api 来解析的，
     * {@link javax.servlet.http.HttpServletRequest}, 需要在配置文件中配置 Bean, 以及在 Servlet 类中配置上传文件的参数，
     * 如最大文件大小、临时存放目录等, 同时 Spring 提供了 MultipartFile 接口处理 part 的数据
     * <p>
     * <p>
     * Spring MultipartFile adapter, wrapping a Servlet 3.0 Part object.  MultipartFile 的实现类的所有方法就是封装了 Part 接口的方法
     *
     * <p>
     * Spring MVC也能接受 javax.servlet.http.Part 作为控制器方法的参数。使用Part来替换MultipartFile的话，
     * 就没有必要配置MultipartResolver了
     * <p>
     * RedirectAttributes 重定向属性，是 Model 的一个子接口， 实现了 flash 属性，可以将发起重定向的方法中的数据放到会话中，以便在
     * 重定向方法中使用
     *
     * @param filePart
     * @param user
     * @param errors
     * @param model
     * @return
     */
    @RequestMapping(value = "/register/multipart", method = RequestMethod.POST)
    public String processRegistrationMultipart(@RequestPart("profilePicture") Part filePart,
                                               @RequestPart("email") Part emailPart,
                                               @Valid User user, Errors errors, RedirectAttributes model) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> printError(error));
            // profilePictureFile.transferTo(new File("/" + profilePictureFile.getOriginalFilename()));
            // 如果使用 Part，就没有必要配置 MultiPartResolver Bean 了，可能是因为直接通过 Java Servlet 提供的解析器就将
            // Multipart 的文件解析为 Part 了；MultiPartResolver 本身也是依赖于 Java Servlet 提供的解析器的
            // filePart.write("/" + filePart.getSubmittedFileName());
            return "registerForm";
        }

        System.out.println("email part name:" + emailPart.getName());
        System.out.println("email content type:" + emailPart.getContentType());

        System.out.println("--------" + user.getUsername());
        repository.saveUser(user);

        model.addAttribute("username", user.getUsername());
        model.addFlashAttribute("user", user);

        return "redirect:/blog/{username}";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUser(@PathVariable("username") String username, Model model) {

        if (model.containsAttribute("username")) {
            System.out.println("model contains username");
        }

        if (!model.containsAttribute("user")) {
            User user = repository.getUserByUsername(username);
            if (Objects.isNull(user)) throw new NoUserException();
            model.addAttribute("user", user.toString());
            System.out.println("Model does not contains attribute: user");
        }

        System.out.println("Ready to show user info......");
        return "userInfo";
    }

    /**
     * 使用 @ExceptionHandler 注解将控制器中的异常处理剥离开来，同样也返回一个视图名
     */
    // @ExceptionHandler(NoUserException.class)
    // public String exceptionHandler() {
    //     return "noSuchUser";
    // }
    private void printError(ObjectError error) {
        System.out.println(error.getObjectName());
        System.out.println(error.getDefaultMessage());
        System.out.println(error.getCode());
        System.out.println(error.getArguments());
        System.out.println(error.toString());
        System.out.println("-------------");
    }
}
