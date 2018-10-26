package com.example.demo_jpa.service;

import com.example.demo_jpa.model.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);

    List<Role> findAll();
}
