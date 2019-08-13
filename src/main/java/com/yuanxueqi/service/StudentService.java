package com.yuanxueqi.service;

import com.yuanxueqi.dao.StudentDao;
import com.yuanxueqi.enums.Status;
import com.yuanxueqi.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  StudentDao studentDao;

  public Student getStudent(int id) {
    return studentDao.select(id);
  }

  public int updateStatus(int id, int status) {
    return studentDao.update(id, Status.get(status));
  }

  public void deleteStudent(int id) {
    studentDao.delete(id);
  }

  public void insertStudent(Student student) {
    studentDao.insert(student);
  }
}
