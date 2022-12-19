package com.dckxx.entity;

import lombok.Data;

import java.util.Date;

/**
 * 学生实体类
 * @author dckxx
 */
@Data
public class StudentEntity {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 性别(0其他 1男 2女)
     */
    private Integer sex;
    /**
     * 入学时间
     */
    private Date createTime;

}
