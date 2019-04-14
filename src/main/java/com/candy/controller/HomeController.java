package com.candy.controller;

import com.candy.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // value 是一个String数组，可以处理 / /homepage 的请求
    @RequestMapping(value = {"/", "/homepage"}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Hello There");
        model.addAttribute("body", "Hello World!");
        return "home";
    }
}
