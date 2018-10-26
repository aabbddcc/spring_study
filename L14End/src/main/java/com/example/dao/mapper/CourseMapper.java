package com.example.dao.mapper;

import com.example.dao.CommonMapper;
import com.example.dao.model.Course;
import com.example.util.StringUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Component注解不添加也没没关系，不加的话service在引入LearnMapper会有错误提示，但不影响
 * SpringBoot使用Mybatis注解进行一对多和多对多查询 https://blog.csdn.net/KingBoyWorld/article/details/78966789
 */
@Component
@Mapper
public interface CourseMapper extends CommonMapper<Course> {
//public interface CourseMapper {
    String getAuthorName(Long id);

    @Insert("insert into course(author, title,url) values(#{author},#{title},#{url})")
    int insert(Course course);

    @Update("update course set author=#{author},title=#{title},url=#{url} where id = #{id}")
    int update(Course course);

    @DeleteProvider(type = CourseSqlBuilder.class, method = "deleteByids")
    int deleteByIds(@Param("ids") String[] ids);


    @Select("select * from course where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(property = "author", column = "author", javaType = Long.class),
            @Result(property = "title", column = "title", javaType = String.class),
            @Result(property = "user", column = "author",
                    one = @One(select = "com.example.dao.mapper.UserMapper.findUserById"))
    })
    Course selectByKey(@Param("id") Long id);

    @SelectProvider(type = CourseSqlBuilder.class, method = "queryCourseByParams")
    @Results({
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(property = "author_id", column = "author", javaType = Long.class),
            @Result(property = "title", column = "title", javaType = String.class),
            @Result(property = "author", column = "author",
                    one = @One(select = "com.example.dao.mapper.UserMapper.findUserNickyById"))
    })
    List<Course> queryList(Map<String, Object> params);

    class CourseSqlBuilder {
        public String queryCourseByParams(final Map<String, Object> params) {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from course where 1=1");
            if (!StringUtil.isNull((String) params.get("author"))) {
                sql.append(" and author like '%").append((String) params.get("author")).append("%'");
            }
            if (!StringUtil.isNull((String) params.get("title"))) {
                sql.append(" and title like '%").append((String) params.get("title")).append("%'");
            }
            System.out.println("查询sql==" + sql.toString());
            return sql.toString();
        }

        //删除的方法
        public String deleteByids(@Param("ids") final String[] ids) {
            StringBuffer sql = new StringBuffer();
            sql.append("DELETE FROM course WHERE id in(");
            for (int i = 0; i < ids.length; i++) {
                if (i == ids.length - 1) {
                    sql.append(ids[i]);
                } else {
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            return sql.toString();
        }
    }
}