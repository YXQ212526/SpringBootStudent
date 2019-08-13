package com.yuanxueqi.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.yuanxueqi.pojo.Score;
import com.yuanxueqi.pojo.StuCourScor;

@Mapper
public interface ScoreDao {


  List<StuCourScor> select(@Param("studentId") int studentId, @Param("year") int year);


  List<StuCourScor> getTop10();


  List<StuCourScor> GPA();


  void insert(Score score);


}
