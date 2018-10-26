package com.example.demo_jpa.service;

import com.example.demo_jpa.model.Role;
import com.example.demo_jpa.model.RoleRepository;
import com.example.demo_jpa.model.User;
import com.example.demo_jpa.model.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id + "");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findPageable(int pageNow) {
        Pageable pageable = new PageRequest(pageNow, 10, Sort.Direction.DESC, "id");
        return userRepository.findAll(pageable);
    }

    @Override
    public User setUserRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId + "");
        Role role = roleRepository.findById(roleId + "");

        user.setRoles(new ArrayList<Role>(){{
            add(role);
        }});
        return saveUser(user);
    }
}
