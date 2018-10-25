package com.example.dao.mapper;

import com.example.dao.CommonMapper;
import com.example.dao.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends CommonMapper<User> {

    /**
     * 根据用户id查询用户
     */
    @Select("SELECT * FROM `user` WHERE id = #{id}")
    User findUserById(Long id);

    /**
     * 根据用户id查询用户名
     */
    @Select("SELECT nicky FROM `user` WHERE id = #{id}")
    String findUserNickyById(Long id);
}