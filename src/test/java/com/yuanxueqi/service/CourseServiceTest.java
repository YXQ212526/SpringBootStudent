package com.yuanxueqi.service;

import com.yuanxueqi.pojo.Course;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CourseServiceTest {

  @Autowired
  CourseService courseService;

  @Test
  public void course_get() {
    insertCourse();
    Assert.assertEquals("math", courseService.getCourse(1).getName());
  }

  public void insertCourse() {
    Course course = new Course();
    course.setName("math");
    course.setId(1);
    Course course1 = new Course();
    course1.setName("comic");
    course1.setId(2);
    courseService.insertCourse(course);
    courseService.insertCourse(course1);
  }

  @Test
  public void updateCourse() {
    courseService.updateCourse(2, "eng");
    Assert.assertEquals("eng", courseService.getCourse(2).getName());
  }

  public void deleteCourse(int id) {
    courseService.deleteCourse(1);
    Assert.assertNull(courseService.getCourse(1));
  }
}