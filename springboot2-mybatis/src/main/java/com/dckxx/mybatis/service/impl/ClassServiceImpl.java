package com.dckxx.mybatis.service.impl;

import com.dckxx.mybatis.mapper.ClassMapper;
import com.dckxx.mybatis.service.IClassService;
import com.dckxx.mybatis.vo.ClassStudentVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ClassServiceImpl implements IClassService {
    @Resource
    private ClassMapper classMapper;

    @Override
    public ClassStudentVO queryClassStudentInfoById(int id) {
        classMapper.queryClassStudentInfoById(id);
        return classMapper.queryClassStudentInfoById(id);
    }
}
