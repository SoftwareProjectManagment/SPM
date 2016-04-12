package main.java.bupt.service;

import main.java.bupt.dao.StudentDao;
import main.java.bupt.domain.Student;
import main.java.bupt.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Martin on 2015/12/23.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    @Transactional
    public List<Student> getStudent(String studentName) {
        return studentDao.getStudent(studentName);
    }

    @Override
    @Transactional
    public List<Student> getStudent(int studentNumber) {
        return studentDao.getStudent(studentNumber);
    }

    @Override
    public Student listToStudent(List<Student> studentList) {
        return studentDao.listToStudent(studentList);
    }

    @Override
    @Transactional
    public String isStudentExist(Student student) {
        return studentDao.isStudentExist(student);
    }

    @Override
    @Transactional
    public String isStudentExist(int studentNum) {
        return studentDao.isStudentExist(studentNum);
    }

    @Override
    @Transactional
    public List<Student> getExistStudent(Team team) {
        return studentDao.getExistStudent(team);
    }

    @Override
    @Transactional
    public String deleteTeamStudent(int studentNum) {
        return studentDao.deleteTeamStudent(studentNum);
    }
}
