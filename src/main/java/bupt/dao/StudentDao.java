package main.java.bupt.dao;

import main.java.bupt.domain.Student;
import main.java.bupt.domain.Team;

import java.util.List;

/**
 * 数据访问接口
 * Created by Martin on 2015/12/23.
 */
public interface StudentDao {
    void insert(Student student);

    public List<Student> getStudent(String studentName);

    public List<Student> getStudent(int studentNumber);

    public Student listToStudent(List<Student> studentList);

    public String isStudentExist(Student student);

    public String isStudentExist(int studentNum);

    public List<Student> getExistStudent(Team team);

    public String deleteTeamStudent(int studentNum);

}
