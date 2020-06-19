package com.littlepage.entity;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author 
 * 
 */
public class Student {
    @ExcelProperty(value = "编号", index = 0)
    private Integer id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ExcelProperty(value = "性别", index = 2)
    private String sex;

    @ExcelProperty(value = "学号", index = 3)
    private String stuNum;

    @ExcelProperty(value = "邮箱", index = 4)
    private String email;

    @ExcelProperty(value = "专业", index = 5)
    private String major;

    @ExcelProperty(value = "个人信息", index = 6)
    private String info;

    @ExcelProperty(value = "密码", index = 7)
    private String passwd;

    public Student() {
    }

    public Student(Integer id, String name, String sex, String stuNum, String email, String major, String info, String passwd) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.stuNum = stuNum;
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

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", info='" + info + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}