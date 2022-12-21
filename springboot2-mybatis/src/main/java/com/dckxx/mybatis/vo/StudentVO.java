package com.dckxx.mybatis.vo;

import com.dckxx.mybatis.entity.ClassEntity;
import com.dckxx.mybatis.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentVO extends StudentEntity {

    private ClassEntity classEntity;
}
