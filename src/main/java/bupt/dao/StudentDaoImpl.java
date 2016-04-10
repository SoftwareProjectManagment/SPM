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

    public List<Student> getStudent(String studentName){
        return (List<Student>) sessionFactory.getCurrentSession().createQuery("from Student where name = :name").setParameter("name",studentName).list();
    }
}
