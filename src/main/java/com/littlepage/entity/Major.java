package com.littlepage.entity;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Major implements Serializable {
    private Integer id;

    private String name;

    private Integer max;

    private String info;

    public Major() {
    }

    public Major(Integer id, String name, Integer max, String info) {
        this.id = id;
        this.name = name;
        this.max = max;
        this.info = info;
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

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max=" + max +
                ", info='" + info + '\'' +
                '}';
    }
}