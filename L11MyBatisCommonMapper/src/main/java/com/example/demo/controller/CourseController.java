package com.example.demo.controller;

import com.example.demo.dao.model.Course;
import com.example.demo.dao.model.CourseQueryList;
import com.example.demo.dao.service.CourseService;
import com.example.demo.util.AjaxObject;
import com.example.demo.util.Page;
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
 */
@Controller
@RequestMapping("/learn")
public class CourseController extends BaseController {
    @Autowired
    private CourseService courseService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "learn-resource";
    }

    /**
     * 查询教程列表
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/queryLeanList", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject queryLearnList(Page<CourseQueryList> page) {
        List<Course> learnList = courseService.queryCourseList(page);
        PageInfo<Course> pageInfo = new PageInfo<Course>(learnList);
        return AjaxObject.ok().put("page", pageInfo);
    }

    /**
     * 新添教程
     *
     * @param course
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addLearn(@RequestBody Course course) {
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
    public AjaxObject updateLearn(@RequestBody Course course) {
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
    public AjaxObject deleteLearn(@RequestBody Long[] ids) {
        courseService.deleteBatch(ids);
        return AjaxObject.ok();
    }
}