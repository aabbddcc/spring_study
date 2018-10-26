package com.example.demo_jpa.model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/*
DROP DATABASE IF EXISTS student;
CREATE DATABASE student DEFAULT CHARACTER SET utf8;
* */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements Serializable {
    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

//    @GenericGenerator(name = "idGenerator",strategy = "uuid")
//    @GeneratedValue(generator = "idGenerator")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private Integer age;

    private String position;

    private String email;

    @ManyToMany
    private List<Role> roles;
}
