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
public class Admin {
    private Integer id;

    private String name;

    private String sex;

    private String role;

    private String passwd;
}