package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/*
运行后浏览器中访问：
http://localhost:8080/index
http://localhost:8080/index2
*/
@Controller
public class HelloController {
    private static List<Course> getCourses(){
        List<Course> courses =new ArrayList<Course>();
        Course bean =new Course("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        courses.add(bean);
        courses.add(bean);
        courses.add(bean);
        bean =new Course("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        courses.add(bean);
        courses.add(bean);
        courses.add(bean);

        return courses;
    }

    @RequestMapping("/index")
    private ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("courses", getCourses());
        return modelAndView;
    }

    @RequestMapping("/index2")
    private ModelAndView index2(){
        ModelAndView modelAndView = new ModelAndView("/index2");
        modelAndView.addObject("courses", getCourses());
        return modelAndView;
    }
}
