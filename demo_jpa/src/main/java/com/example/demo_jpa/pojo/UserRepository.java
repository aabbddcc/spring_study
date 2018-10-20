package com.example.demo_jpa.pojo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

//    @Query("select u from User u where u.name=:name and u.age=:age")
//    List<User> findByNameAndAge(String attribute, String value);

    @Query("from User u where u.name=:name and u.age=:age")
    List<User> findByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    @Query("from User u where u.name=:name")
    List<User>  findUser(@Param("name") String name);


}

