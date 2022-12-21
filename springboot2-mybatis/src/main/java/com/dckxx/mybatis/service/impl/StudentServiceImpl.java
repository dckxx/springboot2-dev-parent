package com.dckxx.mybatis.service.impl;

import com.dckxx.mybatis.entity.StudentEntity;
import com.dckxx.mybatis.mapper.StudentMapper;
import com.dckxx.mybatis.service.IStudentService;
import com.dckxx.mybatis.vo.StudentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<StudentEntity> queryList(StudentEntity student) {
        return studentMapper.queryList(student);
    }

    @Override
    public StudentEntity queryOneById(int id) {
        return studentMapper.queryOneById(id);
    }

    @Override
    public StudentEntity queryOneByMap(Map<String, Object> map) {
        return studentMapper.queryOneByMap(map);
    }

    @Override
    public boolean addStudent(StudentEntity studentEntity) {
        return studentMapper.addStudent(studentEntity)>0;
    }

    @Override
    public boolean updateStudentById(StudentEntity studentEntity) {
        return studentMapper.updateStudentById(studentEntity)>0;
    }

    @Override
    public boolean deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id)>0;
    }

    @Override
    public boolean addStudentReturnId(StudentEntity student) {
        return studentMapper.addStudentReturnId(student)>0;
    }

    @Override
    public boolean addStudentSelectKey(StudentEntity student) {
        return studentMapper.addStudentSelectKey(student)>0;
    }

    @Override
    public boolean deleteStudentBatch(String[] ids) {
        return studentMapper.deleteStudentBatch(ids)>0;
    }

    @Override
    public Map<String, Object> queryOneByIdReturnMap(int id) {
        return studentMapper.queryOneByIdReturnMap(id);
    }

    @Override
    public List<Map<String, Object>> queryReturnListMap() {
        return studentMapper.queryReturnListMap();
    }

    @Override
    public List<StudentVO> queryStudentInfo() {
        return studentMapper.queryStudentInfo();
    }
}
