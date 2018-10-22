package com.example.demo.dao.service;

import com.example.demo.dao.model.Course;
import com.example.demo.dao.model.CourseQueryList;
import com.example.demo.util.Page;

import java.util.List;

public interface CourseService extends BaseService<Course>{
    public List<Course> queryCourseList(Page<CourseQueryList> page);
    public void deleteBatch(Long[] ids);
}
