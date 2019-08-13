//package com.yuanxueqi.dao;
//
//
//import javax.annotation.Resource;
//
//import com.yuanxueqi.enums.Status;
//
//import org.junit.Assert;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.yuanxueqi.pojo.Student;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath*:myxml.xml")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Component
//public class StudentDaoTest {
//
//  @Resource
//  StudentDao studentDao;
//
//  public void insert() {
//    Student student1 = new Student();
//    student1.setId(1);
//    student1.setName("jim");
//    Student student2 = new Student();
//    student2.setId(2);
//    student2.setName("alice");
//    Student student3 = new Student();
//    student3.setId(3);
//    student3.setName("bob");
//
//    studentDao.insert(student1);
//    studentDao.insert(student2);
//    studentDao.insert(student3);
//
//
//  }
//
//
//  @Test
//  public void select() {
//
//    Assert.assertEquals(studentDao.select(1).getName(), "jim");
//    Assert.assertEquals(studentDao.select(2).getStatus(), "正常");
//    Assert.assertNull(studentDao.select(0));
//  }
//
//
//  @Test
//  public void update() {
//    Student student1 = new Student();
//    student1.setId(1);
//    student1.setStatus(10);
//
//    Student student2 = new Student();
//    student2.setId(2);
//    student2.setStatus(1);
//
//    Student student3 = new Student();
//    student3.setId(10);
//    student3.setStatus(1);
//
//    int result = studentDao.update(student1);
//    int result1 = studentDao.update(student2);
//    int result2 = studentDao.update(student3);
//
//    Assert.assertEquals(studentDao.select(2).getStatus(), Status.get(1));
//    Assert.assertEquals(studentDao.select(1).getStatus(), "正常");
//    Assert.assertSame(1, result);
//    Assert.assertSame(1, result1);
//    Assert.assertSame(0, result2);
//
//  }
//
//  @Test
//  public void delete() {
//    insert();
//    studentDao.delete(3);
//    Assert.assertNull(studentDao.select(3));
//  }
//
//}
