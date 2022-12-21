package com.dckxx.mybatis.controller;

import com.dckxx.mybatis.common.vo.Result;
import com.dckxx.mybatis.service.IClassService;
import com.dckxx.mybatis.vo.ClassStudentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("class")
public class ClassController {

    @Resource
    private IClassService classService;
    /**
     * 获取班级学生列表
     * @return
     */
    @GetMapping("cslist/{id}")
    public Result<?> getClassStudentList(@PathVariable("id") int id) {
        ClassStudentVO classStudentVO = classService.queryClassStudentInfoById(id);
        return Result.OK(classStudentVO);
    }
}
