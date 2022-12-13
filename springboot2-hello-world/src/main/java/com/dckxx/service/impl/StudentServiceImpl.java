package com.dckxx.service.impl;

import com.dckxx.entity.StudentEntity;
import com.dckxx.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentServiceImpl implements IStudentService {

    /**
     * 用于模拟数据库数据
     */
    private static List<StudentEntity> list = new ArrayList<>();

    @Override
    public List<StudentEntity> queryList() {
        return list;
    }

    @Override
    public StudentEntity queryOneById(String id) {
        return list.stream().filter(f -> id.equals(f.getId())).findFirst().orElseGet(null);
    }

    @Override
    public boolean addStudent(StudentEntity studentEntity) {
        return list.add(studentEntity);
    }

    @Override
    public StudentEntity updateStudentById(StudentEntity studentEntity) {
        if(list.size() == 0) {
            return null;
        }
        AtomicReference<StudentEntity> updateStudent = new AtomicReference<>();
        list.forEach(student -> {
            if(studentEntity.getId().equals(student.getId())){
                if(studentEntity.getAge() != null) {
                    student.setAge(studentEntity.getAge());
                }
                if(studentEntity.getName() != null && !"".equals(studentEntity.getName())) {
                    student.setName(studentEntity.getName());
                }
                if(studentEntity.getHobby() != null && !"".equals(studentEntity.getHobby())) {
                    student.setHobby(studentEntity.getHobby());
                }
                updateStudent.set(student);
            }
        });
        return updateStudent.get();
    }

    @Override
    public boolean deleteStudentById(String id) {
        boolean delFlag = false;
        if(list.size() > 0) {
            Iterator<StudentEntity> iterator = list.iterator();
            while (iterator.hasNext()){
                StudentEntity student = iterator.next();
                if(id.equals(student.getId())) {
                    list.remove(student);
                    delFlag = true;
                    break;
                }
            }
        }
        return delFlag;
    }
}
