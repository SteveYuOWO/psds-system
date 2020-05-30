package com.littlepage.entity;

public class DualChoose {
    Integer teacherId;

    Integer studentId;

    /**
     * status 状态， 0为已经选择该老师，1为老师已经选择该学生，2为管理员通过确认
     */
    Integer status;

    public DualChoose() {
    }

    public DualChoose(Integer teacherId, Integer studentId, Integer status) {
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.status = status;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DualChoose{" +
                "teacherId=" + teacherId +
                ", studentId=" + studentId +
                ", status=" + status +
                '}';
    }
}
