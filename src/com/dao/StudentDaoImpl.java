package com.dao;


import com.entity.StudentEntity;
import com.entity.TeamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void insert(StudentEntity student) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(student);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<StudentEntity> getStudent(String studentName) {
        Session session = getCurrentSession();
        List<StudentEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<StudentEntity>) session.createQuery("from StudentEntity where name = :name").setParameter("name",studentName).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public List<StudentEntity> getStudent(int studentNumber) {
        Session session = getCurrentSession();
        List<StudentEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<StudentEntity>) session.createQuery("from StudentEntity where id = :number").setParameter("number",studentNumber).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public StudentEntity listToStudent(List<StudentEntity> studentList) {
        StudentEntity student = new StudentEntity();
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
    public String isStudentExist(StudentEntity student) {
        int studentID = student.getId();
        List<StudentEntity> students = getStudent(studentID);
        if (students.isEmpty()){
            return "notExist";
        }
        else{
            return "exist";
        }
    }

    @Override
    public String isStudentExist(int studentNum) {
        List<StudentEntity> students = getStudent(studentNum);
        if (students.isEmpty()){
            return "notExist";
        }
        else{
            return "exist";
        }
    }

    @Override
    public List<StudentEntity> getExistStudent(TeamEntity team) {
        List<StudentEntity> studentList = null;
        List<StudentEntity> tempStudent;
        tempStudent = getStudent(team.getMemberOne());
        if (!tempStudent.isEmpty()){
            StudentEntity student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberTwo());
        if (!tempStudent.isEmpty()){
            StudentEntity student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberThree());
        if (!tempStudent.isEmpty()){
            StudentEntity student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberFour());
        if (!tempStudent.isEmpty()){
            StudentEntity student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberFive());
        if (!tempStudent.isEmpty()){
            StudentEntity student = listToStudent(tempStudent);
            if (studentList == null){
                studentList=tempStudent;
            }
            else{
                studentList.add(student);
            }
        }

        tempStudent = getStudent(team.getMemberSix());
        if (!tempStudent.isEmpty()){
            StudentEntity student = listToStudent(tempStudent);
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
        StudentEntity student = listToStudent(getStudent(studentNum));
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
