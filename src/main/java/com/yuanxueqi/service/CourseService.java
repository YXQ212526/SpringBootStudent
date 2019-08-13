package com.yuanxueqi.service;

import com.yuanxueqi.dao.CourseDao;
import com.yuanxueqi.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  CourseDao courseDao;

  public Course getCourse(int id) {
    return courseDao.select(id);
  }

  public void insertCourse(Course course) {
    courseDao.insert(course);
  }

  public void updateCourse(int id, String name) {
    courseDao.update(id, name);
  }

  public void deleteCourse(int id) {
    courseDao.delete(id);
  }
}
