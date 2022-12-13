package com.dckxx.entity;

import lombok.Data;

import java.util.Date;

/**
 * 学生实体类
 * @author dckxx
 */
@Data
public class StudentLombokEntity {

    /**
     * 主键id
     */
    private String id;
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
     * 入学时间
     */
    private Date createTime;

}
