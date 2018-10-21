package com.example.useconfigurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
http://localhost:8080/student
http://localhost:8080/student?name=alice&age=19
http://localhost:8080/student?name=alice
* */

@RestController
@EnableAutoConfiguration
public class HelloController {
    @Autowired
    private StudentProperties student_default;

    @RequestMapping("/student")
    private String student(String name, Integer age) {
        if (name == null) {
            name = student_default.getName();
        }
        if (age == null) {
            age = student_default.getAge();
        }
        return String.format("name: %s, age: %d\n", name, age);
    }
}
