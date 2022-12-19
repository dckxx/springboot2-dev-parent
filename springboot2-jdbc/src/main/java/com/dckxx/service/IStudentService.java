package com.dckxx.service;

import com.dckxx.entity.StudentEntity;

import java.util.List;

public interface IStudentService {

    List<StudentEntity> queryList();

    StudentEntity queryOneById(int id);

    boolean addStudent(StudentEntity studentEntity);

    boolean updateStudentById(StudentEntity studentEntity);

    boolean deleteStudentById(int id);
}
