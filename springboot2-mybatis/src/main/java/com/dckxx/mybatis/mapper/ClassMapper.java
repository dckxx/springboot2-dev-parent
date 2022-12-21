package com.dckxx.mybatis.mapper;

import com.dckxx.mybatis.vo.ClassStudentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper {

    ClassStudentVO queryClassStudentInfoById(int id);
}
