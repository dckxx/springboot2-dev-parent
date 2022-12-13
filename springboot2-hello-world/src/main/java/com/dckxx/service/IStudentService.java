package com.dckxx.service;

import com.dckxx.entity.StudentEntity;

import java.util.List;

public interface IStudentService {

    List<StudentEntity> queryList();

    StudentEntity queryOneById(String id);

    boolean addStudent(StudentEntity studentEntity);

    StudentEntity updateStudentById(StudentEntity studentEntity);

    boolean deleteStudentById(String id);
}
