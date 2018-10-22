package com.example.service;

import com.example.dao.CourseMapper;
import com.example.pojo.Course;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;
    @Override
    public int add(Course course) {
        return this.courseMapper.add(course);
    }

    @Override
    public int update(Course course) {
        return this.courseMapper.update(course);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return this.courseMapper.deleteByIds(ids);
    }

    @Override
    public Course queryLearnResouceById(Long id) {
        return this.courseMapper.queryLearnResouceById(id);
    }

    @Override
    public List<Course> queryLearnResouceList(Map<String,Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        return this.courseMapper.queryLearnResouceList(params);
    }
}
