package com.example.service;

import com.example.pojo.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */

public interface CourseService {
    int add(Course course);
    int update(Course course);
    int deleteByIds(String[] ids);
    Course queryLearnResouceById(Long learnResouce);
    List<Course> queryLearnResouceList(Map<String, Object> params);
}
