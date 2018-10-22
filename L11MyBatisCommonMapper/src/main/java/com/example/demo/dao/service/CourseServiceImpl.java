package com.example.demo.dao.service;


import com.example.demo.dao.mapper.CourseMapper;
import com.example.demo.dao.model.Course;
import com.example.demo.dao.model.CourseQueryList;
import com.example.demo.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(id->courseMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<Course> queryCourseList(Page<CourseQueryList> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return courseMapper.queryModelList(page.getCondition());
    }
}
