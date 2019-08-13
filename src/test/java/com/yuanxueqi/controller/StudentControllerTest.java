package com.yuanxueqi.controller;

import java.util.HashMap;
import java.util.Map;


import com.yuanxueqi.enums.Status;
import com.yuanxueqi.pojo.Student;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)
public class StudentControllerTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  private static final String url = "/student";
  private static final int code = 200;

  @Test
  public void a_insert() {
    Student student = new Student();
    student.setName("alice");
    student.setId(1);
    student.setStatus(Status.get(0));
    Student student1 = new Student();
    student1.setName("bob");
    student1.setId(2);
    student1.setStatus(Status.get(1));
    ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url + "/insert", student, String.class);
    Assert.assertEquals(code, responseEntity.getStatusCodeValue());
    ResponseEntity<String> responseEntity1 = testRestTemplate.postForEntity(url + "/insert", student1, String.class);
    Assert.assertEquals(code, responseEntity1.getStatusCodeValue());
  }

  @Test
  public void b_delete() {
    Map<String, Integer> map = new HashMap<>();
    map.put("id", 2);
    ResponseEntity<String> response = testRestTemplate.getForEntity(url + "/delete?id={id}", String.class, map);
    Assert.assertEquals(code, response.getStatusCodeValue());
  }

  @Test
  public void c_update() {
    Map<String,Integer>map =new HashMap<> ();
    map.put("id",1);
    map.put("status",1);
    ResponseEntity<String> response=testRestTemplate.getForEntity(url+"/update?id={id}&status={status}",String.class,map);
    Assert.assertEquals(code, response.getStatusCodeValue());
  }

  @Test
  public void d_select() {
    Map<String,Integer>map =new HashMap<> ();
    map.put("id",1);
    ResponseEntity<Student> response=testRestTemplate.getForEntity(url+"/get",Student.class,map);
    Assert.assertEquals(code, response.getStatusCodeValue());
    Assert.assertEquals(Status.get(1), response.getBody().getStatus());
  }
}
