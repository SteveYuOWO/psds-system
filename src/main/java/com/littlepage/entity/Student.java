package com.littlepage.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ExcelProperty(value = "导师志愿1", index = 7)
    private Integer chooseTeacher1;

    @ExcelProperty(value = "导师志愿2", index = 8)
    private Integer chooseTeacher2;

    @ExcelProperty(value = "导师志愿3", index = 9)
    private Integer chooseTeacher3;

    @ExcelProperty(value = "密码", index = 10)
    private String passwd;
}