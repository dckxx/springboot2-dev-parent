package com.dckxx.mybatis.service;

import com.dckxx.mybatis.entity.StudentEntity;
import com.dckxx.mybatis.vo.StudentVO;

import java.util.List;
import java.util.Map;

public interface IStudentService {

    List<StudentEntity> queryList(StudentEntity student);

    StudentEntity queryOneById(int id);

    StudentEntity queryOneByMap(Map<String,Object> map);

    boolean addStudent(StudentEntity studentEntity);

    boolean updateStudentById(StudentEntity studentEntity);

    boolean deleteStudentById(int id);

    boolean addStudentReturnId(StudentEntity student);

    boolean addStudentSelectKey(StudentEntity student);

    boolean deleteStudentBatch(String[] ids);

    Map<String,Object> queryOneByIdReturnMap(int id);

    List<Map<String,Object>> queryReturnListMap();

    List<StudentVO> queryStudentInfo();


}
