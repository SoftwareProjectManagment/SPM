package main.java.bupt.dao;

import main.java.bupt.domain.Student;
import main.java.bupt.domain.Team;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Martin on 2015/12/23.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Student student) {
        sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    public List<Student> getStudent(String studentName){
        return (List<Student>) sessionFactory.getCurrentSession().createQuery("from Student where name = :name").setParameter("name",studentName).list();
    }

    @Override
    public List<Student> getStudent(int studentNumber) {
        return (List<Student>) sessionFactory.getCurrentSession().createQuery("from Student where id = :id").setParameter("id",studentNumber).list();
    }

    @Override
    public Student listToStudent(List<Student> studentList) {
        Student student = new Student();
        student.setId(studentList.get(0).getId());
        student.setName(studentList.get(0).getName());
        student.setScore(studentList.get(0).getScore());
        student.setGroupnum(studentList.get(0).getGroupnum());
        student.setDeployscore(studentList.get(0).getDeployscore());
        student.setFrontpagescore(studentList.get(0).getFrontpagescore());
        student.setFunctionscore(studentList.get(0).getFunctionscore());
        student.setPerformancescore(studentList.get(0).getPerformancescore());
        student.setCodescore(studentList.get(0).getCodescore());
        student.setDocumentscore(studentList.get(0).getDocumentscore());
        return student;
    }

    @Override
    public String isStudentExist(Student student) {
        int studentID = student.getId();
        List<Student> students = getStudent(studentID);
        if (students.isEmpty()){
            return "notExist";
        }
        else{
            return "exist";
        }
    }

    @Override
    public String isStudentExist(int studentNum) {
        List<Student> students = getStudent(studentNum);
        if (students.isEmpty()){
            return "notExist";
        }
        else{
            return "exist";
        }
    }

    @Override
    public List<Student> getExistStudent(Team team) {
        List<Student> studentList = null;
        List<Student> tempStudent;
        tempStudent = getStudent(team.getMemberOne());
        if (!tempStudent.isEmpty()){
            Student student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberTwo());
        if (!tempStudent.isEmpty()){
            Student student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberThree());
        if (!tempStudent.isEmpty()){
            Student student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberFour());
        if (!tempStudent.isEmpty()){
            Student student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberFive());
        if (!tempStudent.isEmpty()){
            Student student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberSix());
        if (!tempStudent.isEmpty()){
            Student student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }
        return studentList;
    }

    @Override
    public String deleteTeamStudent(int studentNum) {
        Student student = listToStudent(getStudent(studentNum));
        if (student!=null) {
            student.setGroupnum(-1);
            insert(student);
            return "success";
        }
        else {
            return "fail";
        }
    }


}
