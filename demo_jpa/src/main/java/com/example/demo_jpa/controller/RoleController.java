package com.example.demo_jpa.controller;

import com.example.demo_jpa.model.Role;
import com.example.demo_jpa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Role save(Role role){
        return roleService.save(role);
    }

    @RequestMapping(value = "/get")
    public List<Role> findAll(){
        return roleService.findAll();
    }
}
