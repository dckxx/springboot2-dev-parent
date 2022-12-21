package com.dckxx.mybatis.controller;

import com.dckxx.mybatis.common.vo.Result;
import com.dckxx.mybatis.entity.StudentEntity;
import com.dckxx.mybatis.service.IStudentService;
import com.dckxx.mybatis.vo.StudentVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public Result<?> getListResult(StudentEntity student) {
        List<StudentEntity> list = studentService.queryList(student);
        return Result.OK(list);
    }

    /**
     * 获取学生列表
     * @return
     */
    @GetMapping("listInfo")
    public Result<?> queryStudentInfo() {
        List<StudentVO> list = studentService.queryStudentInfo();
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
     * 获取学生信息, 同上
     * @param map
     * @return
     */
    @GetMapping("/map")
    public Result<?> getOneByMap(@RequestParam Map<String,Object> map) {
        StudentEntity student = studentService.queryOneByMap(map);
        return Result.OK(student);
    }

    /**
     * 获取学生信息
     * @param id
     * @return
     */
    @GetMapping("/map/{id}")
    public Result<?> getOneMapById(@PathVariable int id) {
        Map<String, Object> map = studentService.queryOneByIdReturnMap(id);
        return Result.OK(map);
    }

    /**
     * 获取学生信息
     * @return
     */
    @GetMapping("/listMap")
    public Result<?> getListMap() {
        List<Map<String, Object>> list = studentService.queryReturnListMap();
        return Result.OK(list);
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

    /**
     * 新增学生信息返回id
     * @param studentEntity
     * @return
     */
    @PostMapping("addReturnId")
    public Result<?> addReturnId(@RequestBody StudentEntity studentEntity){
        boolean aBoolean = studentService.addStudentReturnId(studentEntity);
        if(aBoolean) {
            System.out.println("当前插入记录的id为:"+studentEntity.getId());
            return Result.OK();
        }else {
            return Result.error("操作失败");
        }
    }

    /**
     * 新增学生信息返回id
     * @param studentEntity
     * @return
     */
    @PostMapping("addSelectKey")
    public Result<?> addStudentSelectKey(@RequestBody StudentEntity studentEntity){
        boolean aBoolean = studentService.addStudentSelectKey(studentEntity);
        if(aBoolean) {
            System.out.println("当前插入记录的id为:"+studentEntity.getId());
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
    @DeleteMapping("deleteBatch/{id}")
    public Result<?> deleteBatch(@PathVariable String id) {
        String[] ids = id.split(",");
        boolean aBoolean = studentService.deleteStudentBatch(ids);
        if(aBoolean) {
            return Result.OK();
        }else {
            return Result.error("操作失败");
        }
    }
}
