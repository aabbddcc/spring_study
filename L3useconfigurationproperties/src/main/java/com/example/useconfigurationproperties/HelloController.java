package com.example.useconfigurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
http://localhost:8080/student
http://localhost:8080/student?name=alice&age=19
http://localhost:8080/student?name=alice

把application.yml中的active改为dev再试一下。
* */

@RestController
@EnableAutoConfiguration
public class HelloController {
    @Value("${version}")
    private String version;

    @Autowired
    private StudentProperties student_default;

    @Autowired
    private StudentTestBean student_test;

    @RequestMapping("/student")
    private String student(String name, Integer age) {
        if (name == null) {
            name = student_default.getName();
        }
        if (age == null) {
            age = student_default.getAge();
        }
        return String.format("Online: %s\nname: %s, age: %d\nname(Test): %s, age(Test): %d", version, name, age, student_test.getName(), student_test.getAge());
    }

}
