package com.dckxx.mybatis.mapper;

import com.dckxx.mybatis.entity.StudentEntity;
import com.dckxx.mybatis.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author dck
 */
@Mapper
public interface StudentMapper {
    List<StudentEntity> queryList(StudentEntity student);

    StudentEntity queryOneById(int id);

    int addStudent(StudentEntity student);

    int updateStudentById(@Param("student") StudentEntity student);

    int deleteStudentById(int id);

    int deleteStudentBatch(String[] ids);

    int addStudentReturnId(StudentEntity student);

    int addStudentSelectKey(StudentEntity student);

    StudentEntity queryOneByMap(Map<String,Object> map);

    Map<String,Object> queryOneByIdReturnMap(int id);

    List<Map<String,Object>> queryReturnListMap();

    List<StudentVO> queryStudentInfo();
}
