package com.example.dao.service;

import com.example.dao.model.Course;
import com.example.util.Page;

import java.util.List;
import java.util.Map;


public interface CourseService extends BaseService<Course> {
    int deleteByIds(String[] ids);
    int deleteByIds(Long[] ids);
    List<Course> queryList(Map<String, Object> params);
    List<Course> queryList(Page<?> page);
}
