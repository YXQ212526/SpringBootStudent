package com.yuanxueqi.controller;
import	java.util.HashMap;

import java.util.Map;

import com.yuanxueqi.pojo.Course;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
public class CourseControllerTest {

  @Autowired
  TestRestTemplate testRestTemplate;
  private static final String url = "/course";
  private static final int code = 200;

  @Test
  public void a_insert()
  {
    Course course = new Course();
    course.setId(1);
    course.setName("math");
    Course course1 = new Course();
    course1.setId(2);
    course1.setName("eng");
    ResponseEntity<String> response=testRestTemplate.postForEntity(url+"/insert",course,String.class);
    Assert.assertEquals(code, response.getStatusCodeValue());

    ResponseEntity<String> response1=testRestTemplate.postForEntity(url+"/insert",course1,String.class);
    Assert.assertEquals(code, response1.getStatusCodeValue());
  }
  @Test
  public void b_delete()
  {
    Map<String,Integer> map =new HashMap<>();

    map.put("id",2);
    ResponseEntity<String> response=testRestTemplate.getForEntity(url+"/delete?id={id}",String.class,map);
    Assert.assertEquals(code, response.getStatusCodeValue());
  }
  @Test
  public void c_update()
  {
    Map<String,Object>map =new HashMap<> ();
    map.put("id",1);
    map.put("name","aaa");
    ResponseEntity<String> response=testRestTemplate.getForEntity(url+"/update?id={id}&name={name}",String.class,map);
    Assert.assertEquals(code, response.getStatusCodeValue());
  }
  @Test
  public void d_select()
  {
    ResponseEntity<Course> response=testRestTemplate.getForEntity(url+"/get/{id}",Course.class,1);
    Assert.assertEquals(code, response.getStatusCodeValue());
    Assert.assertEquals("aaa", response.getBody().getName());
  }
}
