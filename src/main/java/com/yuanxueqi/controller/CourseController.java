package com.yuanxueqi.controller;

import com.yuanxueqi.service.CourseService;
import com.yuanxueqi.pojo.Course;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "课程")
@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired
  CourseService courseService;

  @ApiOperation(value = "获取课程")
  @GetMapping("/get/{id}")
  Course getCourse(@PathVariable(value = "id") int id) {
    return courseService.getCourse(id);
  }

  @ApiOperation(value = "建课")
  @PostMapping("/insert")
  void insertCourse(@RequestBody @ApiParam(value = "课程信息") Course course) {
    courseService.insertCourse(course);
  }

  @ApiOperation(value = "更新课名")
  @GetMapping("/update")
  void updateCourse(@RequestParam @ApiParam(value = "课程ID") int id,
      @RequestParam @ApiParam(value = "新名字") String name) {
    courseService.updateCourse(id, name);
  }

  @ApiOperation(value = "删课")
  @GetMapping("/delete")
  void deleteCourse(@RequestParam @ApiParam(value = "课程ID") int id) {
    courseService.deleteCourse(id);
  }
}
