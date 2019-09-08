package com.candy.controller;

import com.candy.entity.MessageEntity;
import com.candy.exception.NameNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/rest/blog")
public class RestfulController {


    private static final String[] NAMES = new String[]{"Guoph", "Tangxi"};

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public @ResponseBody MessageEntity findMessageByName(@PathVariable String name) {
        return new MessageEntity(name, getNowTime(), "Hi, this is " + name);
    }

    /**
     *
     * 使用 Spring 提供的异常处理机制来专门处理控制器中抛出的异常，使得正常的控制器方法能够专注于正常的
     * 逻辑处理；
     *
     * 而且使用了异常处理机制后，一般情况下，如果不添加修改相应的头部的信息，可以使用 @ResponseBody 注解，
     * 更进一步，可以使用 @RestController 注解简化控制器方法, 让代码更加简洁。
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/responseEntity/{name}", method = RequestMethod.GET)
    public ResponseEntity findMessageByNameRespEntity(@PathVariable String name) {
        if (!Arrays.asList(NAMES).contains(name)) {
            throw new NameNotFoundException(name);
        }

        MessageEntity messageEntity = new MessageEntity(name, getNowTime(), "Hi, this is " + name);
        return new ResponseEntity<>(messageEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity saveMessageEntity(@RequestBody MessageEntity messageEntity, UriComponentsBuilder builder) {

        System.out.println("save ##########");
        // TODO: 2019/8/11 save messageEntity to db
        URI uri = builder.path("/responseEntity/")
                .path(messageEntity.getName())
                .build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);

        return new ResponseEntity<>(messageEntity, headers, HttpStatus.OK);
    }

    private String getNowTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
