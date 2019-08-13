package com.yuanxueqi.controller;

import com.yuanxueqi.service.StudentService;
import com.yuanxueqi.pojo.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "学生信息")
@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  @ApiOperation(value = "获取学生")
  @GetMapping("/get")
  public Student getStudent(@RequestParam @ApiParam("学生ID") int id) {
    return studentService.getStudent(id);
  }

  @ApiOperation(value = "更新在校状态")
  @GetMapping("/update")
  public int updateStatus(@RequestParam @ApiParam("学生ID") int id, @RequestParam @ApiParam("状态") int status) {
    return studentService.updateStatus(id, status);
  }

  @ApiOperation(value = "删除信息")
  @GetMapping("/delete")
  public void deleteStudent(@RequestParam @ApiParam("学生ID") int id) {
    studentService.deleteStudent(id);
  }

  @ApiOperation(value = "插入信息")
  @PostMapping("/insert")
  public void insertStudent(@RequestBody @ApiParam("学生信息") Student student) {
    studentService.insertStudent(student);
  }
}
