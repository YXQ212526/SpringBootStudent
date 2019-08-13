package com.yuanxueqi.service;

import com.yuanxueqi.enums.Status;
import com.yuanxueqi.pojo.Student;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)
public class StudentServiceTest {

  @Autowired
  StudentService studentService;


  @Test
  public void find() {
    insertStudent();
    Assert.assertEquals("amy", studentService.getStudent(1).getName());
    Assert.assertNull(studentService.getStudent(0));
  }

  @Test
  public void status_update() {
    Assert.assertTrue(studentService.updateStatus(1, 2) == 1);
    Assert.assertTrue(studentService.updateStatus(0, 0) == 0);
    Assert.assertEquals(Status.get(2), studentService.getStudent(1).getStatus());
  }

  @Test
  public void student_delete() {
    studentService.deleteStudent(1);
    Assert.assertNull(studentService.getStudent(1));
  }

  public void insertStudent() {
    Student student = new Student();
    student.setName("amy");
    student.setStatus(Status.get(0));
    Student student1 = new Student();
    student1.setName("git");
    student1.setStatus(Status.get(2));
    studentService.insertStudent(student);
    studentService.insertStudent(student1);
  }

}
