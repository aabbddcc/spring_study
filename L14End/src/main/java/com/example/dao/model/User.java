package com.example.dao.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User {
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Long id, String name, String password, String nicky, String phone, String email, String sex, String birthday, Timestamp createtime, Timestamp updatetime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.nicky = nicky;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 登录账号
     */
    private String name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nicky;

    /**
     * 电话
     */
    private String phone;

    /**
     * email地址
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址链接
     */
    private String birthday;

    /**
     * 创建时间
     */
    private Timestamp createtime;

    /**
     * 修改时间
     */
    private Timestamp updatetime;

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
     * 获取登录账号
     *
     * @return name - 登录账号
     */
    public String getName() {
        return name;
    }

    /**
     * 设置登录账号
     *
     * @param name 登录账号
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nicky - 用户昵称
     */
    public String getNicky() {
        return nicky;
    }

    /**
     * 设置用户昵称
     *
     * @param nicky 用户昵称
     */
    public void setNicky(String nicky) {
        this.nicky = nicky == null ? null : nicky.trim();
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取email地址
     *
     * @return email - email地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email地址
     *
     * @param email email地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取地址链接
     *
     * @return birthday - 地址链接
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置地址链接
     *
     * @param birthday 地址链接
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取修改时间
     *
     * @return updatetime - 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置修改时间
     *
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }
}