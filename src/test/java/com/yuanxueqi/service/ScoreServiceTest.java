package com.yuanxueqi.service;

import com.yuanxueqi.enums.Status;
import com.yuanxueqi.pojo.Course;
import com.yuanxueqi.pojo.Score;
import com.yuanxueqi.pojo.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class ScoreServiceTest {

  @Autowired
  ScoreService scoreService;

  @Autowired
  StudentService studentService;
  @Autowired
  CourseService courseService;

  @Test
  public void getScoreByIdYear() {
    insert();
    Assert.assertTrue(scoreService.getScoreByIdYear(1, 2019).size() == 2);
    Assert.assertEquals(50, scoreService.getScoreByIdYear(1, 2019).get(0).getScore().getGoal());
  }

  @Test
  public void getTop10() {
    Assert.assertEquals(1, scoreService.getTop10().size());
    Assert.assertEquals(90, scoreService.getTop10().get(0).getTotal());
  }

  @Test
  public void GPA() {
    Assert.assertEquals(1, scoreService.GPA().size());
    Assert.assertTrue(1.8 == scoreService.GPA().get(0).getGpa());
  }

  public void insert() {
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
    score.setCourseId(1);
    score.setYear(2019);
    score.setGoal(50);
    score.setStudentId(1);
    Score score1 = new Score();
    score1.setCourseId(2);
    score1.setYear(2019);
    score1.setGoal(40);
    score1.setStudentId(1);
    scoreService.insert(score);
    scoreService.insert(score1);
  }
}
