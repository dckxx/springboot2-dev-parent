package com.dckxx.controller;

import com.dckxx.common.vo.Result;
import com.dckxx.entity.StudentEntity;
import com.dckxx.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    /**
     * 获取学生列表
     * @return
     */
    @GetMapping("list")
    public Result<?> getListResult() {
        List<StudentEntity> list = studentService.queryList();
        return Result.OK(list);
    }

    /**
     * 根据学生id获取学生信息, 同上
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable int id) {
        StudentEntity student = studentService.queryOneById(id);
        return Result.OK(student);
    }

    /**
     * 新增学生信息
     * @param studentEntity
     * @return
     */
    @PostMapping("add")
    public Result<?> add(@RequestBody StudentEntity studentEntity){
        boolean aBoolean = studentService.addStudent(studentEntity);
        if(aBoolean) {
            return Result.OK();
        }else {
            return Result.error("操作失败");
        }
    }

    /**
     * 修改学生信息
     * @param studentEntity
     * @return
     */
    @PutMapping("update")
    public Result<?> update(@RequestBody StudentEntity studentEntity) {
        boolean aBoolean = studentService.updateStudentById(studentEntity);
        if(aBoolean) {
            return Result.OK();
        }else {
            return Result.error("操作失败");
        }
    }


    /**
     * 根据学生id删除学生信息, 同上
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public Result<?> delete(@PathVariable int id) {
        boolean aBoolean = studentService.deleteStudentById(id);
        if(aBoolean) {
            return Result.OK();
        }else {
            return Result.error("操作失败");
        }
    }
}
