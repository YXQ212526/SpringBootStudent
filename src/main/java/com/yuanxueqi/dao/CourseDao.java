package com.yuanxueqi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yuanxueqi.pojo.Course;

@Mapper
public interface CourseDao {


  Course select(int id);

  void insert(Course course);

  int update(@Param("id") int id, @Param("name") String name);

  void delete(int id);

}
