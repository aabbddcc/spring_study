package com.example.dao;

import com.example.pojo.Course;
import com.example.util.Page;
import com.example.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/8.
 */
@Repository
public class LearnDaoImpl  implements LearnDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Course learnResouce) {
        return jdbcTemplate.update("insert into course(author, title,url) values(?, ?, ?)",learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl());
    }

    @Override
    public int update(Course learnResouce) {
        return jdbcTemplate.update("update course set author=?,title=?,url=? where id = ?",new Object[]{learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl(),learnResouce.getId()});
    }

    @Override
    public int deleteByIds(String ids){
        return jdbcTemplate.update("delete from course where id in("+ids+")");
    }

    @Override
    public Course queryLearnResouceById(Long id) {
        List<Course> list = jdbcTemplate.query("select * from course where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Course.class));
        if(null != list && list.size()>0){
            Course learnResouce = list.get(0);
            return learnResouce;
        }else{
            return null;
        }
    }

    @Override
    public Page queryLearnResouceList(Map<String,Object> params) {
        StringBuffer sql =new StringBuffer();
        sql.append("select * from course where 1=1");
        if(!StringUtil.isNull((String)params.get("author"))){
            sql.append(" and author like '%").append((String)params.get("author")).append("%'");
        }
        if(!StringUtil.isNull((String)params.get("title"))){
            sql.append(" and title like '%").append((String)params.get("title")).append("%'");
        }
        Page page = new Page(sql.toString(), Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()), jdbcTemplate);
        return page;
    }
}
