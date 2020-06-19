package com.littlepage.entity;

import com.alibaba.excel.annotation.ExcelProperty;

public class FinalTableView {
    @ExcelProperty(value = "学生id", index = 0)
    private Integer studentId;

    @ExcelProperty(value = "学号", index = 1)
    private String studentNum;

    @ExcelProperty(value = "学生姓名", index = 2)
    private String studentName;

    @ExcelProperty(value = "教师id", index = 3)
    private Integer teacherId;

    @ExcelProperty(value = "教工号", index = 4)
    private String teacherNum;

    @ExcelProperty(value = "教师姓名", index = 5)
    private String teacherName;

    @ExcelProperty(value = "专业", index = 6)
    private String major;

    public FinalTableView() {
    }

    public FinalTableView(Integer studentId, Integer teacherId, String studentNum, String teacherNum, String studentName, String teacherName, String major) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.studentNum = studentNum;
        this.teacherNum = teacherNum;
        this.studentName = studentName;
        this.teacherName = teacherName;
        this.major = major;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "FinalTableView{" +
                "studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", studentNum='" + studentNum + '\'' +
                ", teacherNum='" + teacherNum + '\'' +
                ", studentName='" + studentName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
