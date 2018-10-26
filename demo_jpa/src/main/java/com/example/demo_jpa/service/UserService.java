package com.example.demo_jpa.service;

import com.example.demo_jpa.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findById(Long id);

    List<User> findAll();

    Page<User> findPageable(int pageNow);

    User setUserRole(Long userId, Long roleId);
}
