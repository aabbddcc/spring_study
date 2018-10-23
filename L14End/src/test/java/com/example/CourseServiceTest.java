package com.example;

import com.example.dao.model.Course;
import com.example.dao.service.CourseService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/*
防止测试对数据库产生垃圾数据，添加注解进行数据回滚：
@Transactional
@Rollback(true)

在使用MySQL的数据库时，要首先保证MySQL当前默认的存储引擎是否是InnoDB：
show variables like '%storage_engine%';

查看表在创建的使用用了什么引擎（输出后查看 ENGINE 后面的就是了）：
show create table course;

如果不是，可以对数据库的表进行设置：
ALTER TABLE course ENGINE=INNODB;

在开启了数据回滚进行测试时，运行输出这样的日志：
10:41:56.760 logback [main] INFO  o.s.t.c.t.TransactionContext - Rolled back transaction for test: ...
* */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    @Transactional
    @Rollback(true)
    public void getCourse() {
        // 测试插入，插入成功的话返回 1
        int n = courseService.save(new Course(1040L, "Spring boot Demo", "https://www.spring.com"));
        Assert.assertThat(n, CoreMatchers.equalTo(1));

        // 测试查询
        Course course = courseService.selectByKey(1001);
        Assert.assertThat(course.getAuthor(), CoreMatchers.equalTo("spring"));

        // 测试删除
        //courseService.delete();
    }
}
