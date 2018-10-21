package com.example.usejsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/*
试试访问：
http://localhost:8080/hello
http://localhost:8080/index
* */
@Controller
public class HelloController {

    @RequestMapping("/index")
    private String index(){
        return "index";
    }

    @RequestMapping("/hello")
    private String hello(Model model) {
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}


