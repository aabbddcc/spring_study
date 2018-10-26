package com.example.dao.service;

import com.example.dao.mapper.CourseMapper;
import com.example.dao.model.Course;
import com.example.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 */
@Service
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public int deleteByIds(String[] ids) {
        return this.courseMapper.deleteByIds(ids);
    }

    @Override
    public int deleteByIds(Long[] ids) {
        String[] string_ids = new String[ids.length];

        for (int i = 0; i < ids.length; i++) {
            string_ids[i] = String.valueOf(ids[i]);
        }
        return this.courseMapper.deleteByIds(string_ids);
    }

    @Override
    public List<Course> queryList(Map<String,Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        return this.courseMapper.queryList(params);
    }

    @Override
    public List<Course> queryList(Page<?> page) {
        return courseMapper.queryList(page.getCondition());
    }
}
