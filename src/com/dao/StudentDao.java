package com.dao;

import com.entity.StudentEntity;
import com.entity.TeamEntity;


import java.util.List;

public interface StudentDao {
    void insert(StudentEntity student);

    public List<StudentEntity> getStudent(String studentName);

    public List<StudentEntity> getStudent(int studentNumber);

    public StudentEntity listToStudent(List<StudentEntity> studentList);

    public String isStudentExist(StudentEntity student);

    public String isStudentExist(int studentNum);

    public List<StudentEntity> getExistStudent(TeamEntity team);

    public String deleteTeamStudent(int studentNum);

}
