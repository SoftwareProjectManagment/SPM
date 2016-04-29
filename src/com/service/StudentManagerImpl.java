package com.service;

import com.dao.StudentDao;
import com.entity.StudentEntity;
import com.entity.TeamEntity;

import java.util.List;

/**
 * Created by Java on 2016/4/18.
 */

public class StudentManagerImpl {

    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void insert(StudentEntity student) {
        studentDao.insert(student);
    }

    public List<StudentEntity> getStudent(String studentName) {
        return studentDao.getStudent(studentName);
    }

    public List<StudentEntity> getStudent(int studentNumber) {
        return studentDao.getStudent(studentNumber);
    }

    public StudentEntity listToStudent(List<StudentEntity> studentList) { return studentDao.listToStudent(studentList);}

    public String isStudentExist(StudentEntity student) {
        return studentDao.isStudentExist(student);
    }

    public String isStudentExist(int studentNum) {
        return studentDao.isStudentExist(studentNum);
    }

    public List<StudentEntity> getExistStudent(TeamEntity team) {
        return studentDao.getExistStudent(team);
    }

    public String deleteTeamStudent(int studentNum) {
        return studentDao.deleteTeamStudent(studentNum);
    }

}
