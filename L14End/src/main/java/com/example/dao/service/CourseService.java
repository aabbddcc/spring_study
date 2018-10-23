package com.example.dao.service;

import com.example.dao.model.Course;
import com.example.dao.model.CourseQueryList;
import com.example.util.Page;

import java.util.List;

/**
 * Created by tengj on 2017/4/7.
 */

public interface CourseService extends BaseService<Course> {
    public List<Course> queryModelList(Page<CourseQueryList> page);

    public void deleteBatch(Long[] ids);
}
