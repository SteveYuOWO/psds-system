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
public class Major implements Serializable {
    private Integer id;

    private String name;

    private Integer max;

    private String info;
}