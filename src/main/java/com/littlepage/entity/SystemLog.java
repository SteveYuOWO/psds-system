package com.littlepage.entity;

/**
 * 日志类
 */
public class SystemLog {
    private String ip, name, type, time, comment;

    public SystemLog() {
    }

    public SystemLog(String ip, String name, String type, String time, String comment) {
        this.ip = ip;
        this.name = name;
        this.type = type;
        this.time = time;
        this.comment = comment;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
