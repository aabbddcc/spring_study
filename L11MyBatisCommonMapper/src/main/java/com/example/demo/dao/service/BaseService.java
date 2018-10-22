package com.example.demo.dao.service;


import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 */
@Service
public interface BaseService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    //TODO 其他...
}

