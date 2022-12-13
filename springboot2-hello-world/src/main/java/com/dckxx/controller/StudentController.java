package com.dckxx.controller;

import com.dckxx.common.vo.Result;
import com.dckxx.entity.StudentEntity;
import com.dckxx.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
    public List<StudentEntity> getList() {
        List<StudentEntity> list = studentService.queryList();
        return list;
    }
    /**
     * 获取学生列表, 同上
     * @return
     */
    @GetMapping(value = {"list1","list2"})
    public List<StudentEntity> getList2() {
        List<StudentEntity> list = studentService.queryList();
        return list;
    }


    /**
     * 根据学生id获取学生信息
     * @param id
     * @return
     */
    @GetMapping(value = "getOneById")
    public StudentEntity getOneById(@RequestParam String id) {
        StudentEntity student = studentService.queryOneById(id);
        return student;
    }

    /**
     * 根据学生id获取学生信息, 同上
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public StudentEntity getOne(@PathVariable String id) {
        StudentEntity student = studentService.queryOneById(id);
        return student;
    }

    /**
     * 新增学生信息
     * @param studentEntity
     * @return
     */
    @PostMapping("add")
    public boolean add(@RequestBody StudentEntity studentEntity){
        studentEntity.setCreateTime(new Date());
        return studentService.addStudent(studentEntity);
    }

    /**
     * 根据学生id删除学生信息
     * @param studentEntity
     * @return
     */
    @DeleteMapping("delete")
    public boolean delete(@RequestBody StudentEntity studentEntity) {
        return studentService.deleteStudentById(studentEntity.getId());
    }

    /**
     * 根据学生id删除学生信息, 同上
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return studentService.deleteStudentById(id);
    }

    /**
     * 修改学生信息
     * @param studentEntity
     * @return
     */
    @PutMapping("update")
    public StudentEntity update(@RequestBody StudentEntity studentEntity) {
        return studentService.updateStudentById(studentEntity);
    }

    /**
     * 获取学生列表
     * @return
     */
    @GetMapping("listResult")
    public Result<?> getListResult() {
        List<StudentEntity> list = studentService.queryList();
        System.out.println("我是获取学生列表接口");
        return Result.OK(list);
    }
}
