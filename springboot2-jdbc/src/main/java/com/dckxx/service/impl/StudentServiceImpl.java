package com.dckxx.service.impl;

import com.dckxx.common.util.MyJdbcTemplate;
import com.dckxx.entity.StudentEntity;
import com.dckxx.service.IStudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    /**
     * 自动装配数据源
     */
    @Resource
    MyJdbcTemplate jdbcTemplate;

    @Override
    public List<StudentEntity> queryList() {
        String sql = "select id,name,age,sex,hobby,create_time,update_time from t_student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentEntity.class));
    }

    @Override
    public StudentEntity queryOneById(int id) {
        String sql = "select id,name,age,sex,hobby,create_time,update_time from t_student where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(StudentEntity.class), id);
    }

    @Override
    public boolean addStudent(StudentEntity studentEntity) {
        String sql = "insert into t_student(name,sex,age,hobby,create_time)values(?,?,?,?,?)";
        Object[] params = new Object[5];
        params[0] = studentEntity.getName();
        params[1] = studentEntity.getSex();
        params[2] = studentEntity.getAge();
        params[3] = studentEntity.getHobby();
        params[4] = new Date();
        int rows = jdbcTemplate.update(sql,params);
        return rows>0;
    }

    @Override
    public boolean updateStudentById(StudentEntity studentEntity) {
        if (studentEntity.getId() == null) {
            return false;
        }
        StringBuffer sqlBuffer = new StringBuffer("update t_student set ");
        if(StringUtils.isNotEmpty(studentEntity.getName())) {
            sqlBuffer.append("name='").append(studentEntity.getName()).append("',");
        }
        if(studentEntity.getSex() != null) {
            sqlBuffer.append("sex=").append(studentEntity.getSex()).append(",");
        }
        if(studentEntity.getAge() != null) {
            sqlBuffer.append("age=").append(studentEntity.getAge()).append(",");
        }
        if(StringUtils.isNotEmpty(studentEntity.getHobby())) {
            sqlBuffer.append("hobby='").append(studentEntity.getHobby()).append("',");
        }
        if(StringUtils.isNotEmpty(studentEntity.getName())) {
            sqlBuffer.append("update_time=now()");
        }
        String sql = sqlBuffer.toString();
        //=说明需要设置
        if(sql.contains("=")) {
            if(sql.lastIndexOf(",") == sql.length()) {
                sql = sql.substring(sql.length() - 1);
            }
            sql += " where id="+studentEntity.getId();
            System.out.println("当前sql:"+sql);
        }else {
            return false;
        }
        return jdbcTemplate.update(sql)>0;
    }

    @Override
    public boolean deleteStudentById(int id) {
        String sql = "delete from t_student where id="+id;
        return jdbcTemplate.update(sql)>0;
    }
}
