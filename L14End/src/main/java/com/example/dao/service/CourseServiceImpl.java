package com.example.dao.service;

import com.example.dao.mapper.CourseMapper;
import com.example.dao.model.Course;
import com.example.dao.model.CourseQueryList;
import com.example.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(id -> courseMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<Course> queryModelList(Page<CourseQueryList> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return courseMapper.queryModelList(page.getCondition());
    }
}
