package com.example.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
运行后在浏览器中访问：
http://localhost:8080
http://localhost:8080/index
*/
@RestController
public class HelloController {
    @RequestMapping({"/", "/index"})
    private String index() {
        return "hello world";
    }
}
