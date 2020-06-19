package com.littlepage.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Teacher implements Serializable {
    @ExcelProperty(value = "编号", index = 0)
    private Integer id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ExcelProperty(value = "性别", index = 2)
    private String sex;

    @ExcelProperty(value = "教工号", index = 3)
    private String teaNum;

    @ExcelProperty(value = "邮箱", index = 4)
    private String email;

    @ExcelProperty(value = "专业", index = 5)
    private String major;

    @ExcelProperty(value = "个人信息", index = 6)
    private String info;

    @ExcelProperty(value = "密码", index = 7)
    private String passwd;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String sex, String teaNum, String email, String major, String info, String passwd) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.teaNum = teaNum;
        this.email = email;
        this.major = major;
        this.info = info;
        this.passwd = passwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", teaNum='" + teaNum + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", info='" + info + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}