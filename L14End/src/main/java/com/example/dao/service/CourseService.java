package com.example.dao.service;

import com.example.dao.model.Course;
import com.example.util.Page;

import java.util.List;

/**
 * Created by tengj on 2017/4/7.
 */

public interface CourseService extends BaseService<Course> {
    public List<Course> queryList(Page<?> page);

    public void deleteBatch(Long[] ids);
}
