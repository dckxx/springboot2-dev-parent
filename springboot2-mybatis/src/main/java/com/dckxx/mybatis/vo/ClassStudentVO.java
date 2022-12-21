package com.dckxx.mybatis.vo;

import com.dckxx.mybatis.entity.ClassEntity;
import com.dckxx.mybatis.entity.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class ClassStudentVO extends ClassEntity {

    private List<StudentEntity> studentList;
}
