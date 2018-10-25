package com.example.dao.model;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "course")
public class Course {
    public Course(){
    }

    public Course(Long author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }

    public Course(Long id, Long author, String title, String url) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.url = url;
    }

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long author;
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * 描述
     */
    private String title;

    /**
     * 地址链接
     */
    private String url;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return author
     */
    public Long getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(Long author) {
        this.author = author;
    }

    /**
     * 获取描述
     *
     * @return title - 描述
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置描述
     *
     * @param title 描述
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取地址链接
     *
     * @return url - 地址链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置地址链接
     *
     * @param url 地址链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}