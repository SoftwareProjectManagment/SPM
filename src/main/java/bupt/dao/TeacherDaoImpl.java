package main.java.bupt.dao;

import main.java.bupt.domain.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Java on 2016/3/14.
 */
@Repository
@SessionScoped
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Teacher teacher) {
        sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().saveOrUpdate(teacher);
    }

    @Override
    public void delete(int teacherID) {
        sessionFactory.getCurrentSession().delete(this.getTeacher(teacherID));
    }

    @Override
    public void update(Teacher teacher) {
        sessionFactory.getCurrentSession().saveOrUpdate(teacher);
    }

    @Override
    public List<Teacher> getTeacher(int teacherID) {
        return (List<Teacher>) sessionFactory.getCurrentSession().createQuery("from Teacher where id = :number").setParameter("number",teacherID).list();
    }

    @Override
    public Teacher listToTeacher(List<Teacher> teacherList) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherList.get(0).getId());
        teacher.setName(teacherList.get(0).getName());
        return teacher;
    }
}
