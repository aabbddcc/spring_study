package com.example.demo.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

//FIXME 特别注意，该接口不能被扫描到，否则会出错
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
    List<T> queryModelList(Map<String,Object> map);
}