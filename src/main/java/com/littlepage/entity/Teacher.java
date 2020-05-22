package com.littlepage.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
@Accessors(chain = true)
public class Teacher implements Serializable {
    private Integer id;

    private String name;

    private String sex;

    private String teaNum;

    private String email;

    private String major;

    private String info;

    private Integer chooseStudent;

    private String passwd;
}