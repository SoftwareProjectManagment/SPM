package main.java.bupt.dao;

import main.java.bupt.domain.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Martin on 2015/12/23.
 */
@Repository
@SessionScoped
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Student student) {
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
        student.setGroup(studentList.get(0).getGroup());
        student.setDeployscore(studentList.get(0).getDeployscore());
        student.setFrontpagescore(studentList.get(0).getFrontpagescore());
        student.setFunctionscore(studentList.get(0).getFunctionscore());
        student.setPerformancescore(studentList.get(0).getPerformancescore());
        student.setCodescore(studentList.get(0).getCodescore());
        student.setDocumentscore(studentList.get(0).getDocumentscore());
        return student;
    }
}
