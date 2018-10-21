package com.example.useconfigdata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @Value("${student.name}")
    private  String name;

    @Value("${student.age}")
    private  Integer age;

    @Value("${content}")
    private  String content;

    @RequestMapping("/")
    private String index(){
        return content;
    }

    @RequestMapping("/index")
    private String index2(){
        return String.format("student: %s, age: %d\n", this.name, this.age);
    }
}
