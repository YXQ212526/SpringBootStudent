package com.yuanxueqi.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yuanxueqi.pojo.Student;

@Mapper
public interface StudentDao {


  Student select(int id);

  void insert(Student student);

  int update(int id, String status);

  void delete(int id);


}