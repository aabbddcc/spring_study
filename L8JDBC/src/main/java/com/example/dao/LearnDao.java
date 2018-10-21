package com.example.dao;

import com.example.pojo.Course;
import com.example.util.Page;

import java.util.Map;

/**
 * Created by tengj on 2017/4/8.
 */
public interface LearnDao {
    int add(Course learnResouce);
    int update(Course learnResouce);
    int deleteByIds(String ids);
    Course queryLearnResouceById(Long id);
    Page queryLearnResouceList(Map<String,Object> params);
}
