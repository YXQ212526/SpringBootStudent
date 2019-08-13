package com.yuanxueqi.controller;

import java.util.List;

import com.yuanxueqi.service.ScoreService;
import com.yuanxueqi.pojo.Score;
import com.yuanxueqi.pojo.StuCourScor;
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

@Api(description = "分数")
@RestController
@RequestMapping("/score")
public class ScoreController {

  @Autowired
  ScoreService scoreService;

  @ApiOperation("根据学号学年获取成绩")
  @GetMapping("/get")
  public List<StuCourScor> getScoreByIdYear(@RequestParam int studentId, @RequestParam int year) {
    return scoreService.getScoreByIdYear(studentId, year);
  }

  @ApiOperation("获取前十名")
  @GetMapping("/top10")
  public List<StuCourScor> getTop10() {
    return scoreService.getTop10();
  }

  @ApiOperation("获取所有学生GPA")
  @GetMapping("/gpa")
  public List<StuCourScor> GPA() {
    return scoreService.GPA();
  }

  @ApiOperation("插入学生分数")
  @PostMapping("/insert")
  public void insert(@RequestBody @ApiParam("分数") Score score) {
    scoreService.insert(score);
  }

}
