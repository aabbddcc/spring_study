package com.example.usemybatis;

import com.example.usemybatis.dao.mapper.StudentMapper;
import com.example.usemybatis.dao.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
DROP DATABASE IF EXISTS student;
CREATE DATABASE student DEFAULT CHARACTER SET utf8;

use student;

CREATE TABLE student(
  id int(11) NOT NULL AUTO_INCREMENT,
  student_id int(11) NOT NULL UNIQUE,
  name varchar(255) NOT NULL,
  age int(11) NOT NULL,
  sex varchar(255) NOT NULL,
  birthday date DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


insert into student(student_id, name, age, sex, birthday) value(2018001, "Alice", 28, "女", "1990-10-18");
insert into student(student_id, name, age, sex, birthday) value(2018002, "Bob", 27, "男", "1991-10-18");
insert into student(student_id, name, age, sex, birthday) value(2018003, "David", 26, "男", "1992-10-18");
insert into student(student_id, name, age, sex, birthday) value(2018004, "Jim", 38, "男", "1980-10-18");
insert into student(student_id, name, age, sex, birthday) value(2018005, "Mark", 18, "男", "2000-10-18");
*/

/*
1、首先创建数据库表
2、运行自动生成器自动生成model和mapper
3、运行Application后浏览器访问：http://localhost:8080/index
* */
@Controller
public class HelloController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping({"/", "/index"})
    private String index(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "index";
    }
}

