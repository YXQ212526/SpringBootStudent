package com.yuanxueqi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.AssertTrue;

import com.yuanxueqi.enums.Status;
import com.yuanxueqi.pojo.Course;
import com.yuanxueqi.pojo.Score;
import com.yuanxueqi.pojo.StuCourScor;
import com.yuanxueqi.pojo.Student;
import com.yuanxueqi.service.CourseService;
import com.yuanxueqi.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ScoreControllerTest {

  @Autowired
  TestRestTemplate testRestTemplate;
  @Autowired
  StudentService studentService;
  @Autowired
  CourseService courseService;

  private static final String url = "/score";
  private static final int code = 200;

  @Test
  public void a_insert() {
    Course course = new Course();
    course.setName("math");
    course.setId(1);
    Course course1 = new Course();
    course1.setName("comic");
    course1.setId(2);
    courseService.insertCourse(course);
    courseService.insertCourse(course1);

    Student student = new Student();
    student.setName("amy");
    student.setStatus(Status.get(0));
    Student student1 = new Student();
    student1.setName("git");
    student1.setStatus(Status.get(2));
    studentService.insertStudent(student);
    studentService.insertStudent(student1);
    Score score = new Score();
    score.setGoal(90);
    score.setStudentId(1);
    score.setYear(2019);
    score.setCourseId(1);

    Score score1 = new Score();
    score1.setGoal(50);
    score1.setStudentId(1);
    score1.setYear(2019);
    score1.setCourseId(2);
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url + "/insert", score, String.class);
    ResponseEntity<String> responseEntity1 = testRestTemplate.postForEntity(url + "/insert", score1, String.class);
    Assert.assertEquals(code, responseEntity.getStatusCodeValue());
    Assert.assertEquals(code, responseEntity1.getStatusCodeValue());
  }

  @Test
  public void gpa() {

    ResponseEntity<List> responseEntity = testRestTemplate.getForEntity(url + "/gpa", List.class);
    Assert.assertEquals(code, responseEntity.getStatusCodeValue());
    Assert.assertEquals(1, responseEntity.getBody().size());

    String string=responseEntity.getBody().get(0).toString();
    Assert.assertTrue(string.contains("2.8"));
  }

  @Test
  public void top10() {
    ResponseEntity<ArrayList> responseEntity = testRestTemplate.getForEntity(url + "/top10", ArrayList.class);
    Assert.assertEquals(code, responseEntity.getStatusCodeValue());
    Assert.assertEquals(1, responseEntity.getBody().size());
    String str = responseEntity.getBody().get(0).toString();
    Assert.assertTrue(str.contains("140"));
  }

  @Test
  public void get() {
    Map<String,Integer> map =new HashMap<>();
    map.put("studentId",1);
    map.put("year",2019);
    ResponseEntity<ArrayList> responseEntity = testRestTemplate.getForEntity(url + "/get?studentId={studentId}&year={year}", ArrayList.class,map);
    Assert.assertEquals(code, responseEntity.getStatusCodeValue());
   Assert.assertEquals(2, responseEntity.getBody().size());
    String string =  responseEntity.getBody().toString();
    Assert.assertTrue(string.contains("name=math"));
  }
}

