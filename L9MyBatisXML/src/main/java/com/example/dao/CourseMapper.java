package com.example.dao;

import com.example.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/22.
 */

@Mapper
public interface CourseMapper {
    int add(Course course);
    int update(Course course);
    int deleteByIds(String[] ids);
    Course queryLearnResouceById(Long id);
    public List<Course> queryLearnResouceList(Map<String, Object> params);
}
