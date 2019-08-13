package com.yuanxueqi.service;

import java.util.List;

import com.yuanxueqi.dao.ScoreDao;
import com.yuanxueqi.pojo.Score;
import com.yuanxueqi.pojo.StuCourScor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

  @Autowired
  ScoreDao scoreDao;

  public List<StuCourScor> getScoreByIdYear(int studentId, int year) {
    return scoreDao.select(studentId, year);
  }

  public List<StuCourScor> getTop10() {
    return scoreDao.getTop10();
  }

  public List<StuCourScor> GPA() {
    return scoreDao.GPA();
  }

  public void insert(Score score) {
    scoreDao.insert(score);
  }
}
