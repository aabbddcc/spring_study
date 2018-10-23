package com.example.controller;


import com.example.dao.model.Course;
import com.example.dao.model.CourseQueryList;
import com.example.dao.service.CourseService;
import com.example.util.AjaxObject;
import com.example.util.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 教程页面
 * Created by tengj on 2017/3/13.
 */
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {
    @Autowired
    private CourseService courseService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String course(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "courses";
    }

    /**
     * 查询教程列表
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/queryLeanList", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject queryCourse(Page<CourseQueryList> page) {
        List<Course> courseList = courseService.queryModelList(page);
        PageInfo<Course> pageInfo = new PageInfo<Course>(courseList);
        return AjaxObject.ok().put("page", pageInfo);
    }

    /**
     * 新添教程
     *
     * @param course
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addCourse(@RequestBody Course course) {
        courseService.save(course);
        return AjaxObject.ok();
    }

    /**
     * 修改教程
     *
     * @param course
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject updateCourse(@RequestBody Course course) {
        logger.info(course.getAuthor());
        courseService.updateNotNull(course);
        return AjaxObject.ok();
    }

    /**
     * 删除教程
     *
     * @param ids
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject deleteCourse(@RequestBody Long[] ids) {
        courseService.deleteBatch(ids);
        return AjaxObject.ok();
    }
}