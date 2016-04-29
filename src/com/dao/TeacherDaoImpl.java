package com.dao;

import com.entity.TeacherEntity;
import com.entity.TeamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Java on 2016/3/14.
 */

public class TeacherDaoImpl implements TeacherDao {

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
    public void insert(TeacherEntity teacher) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(teacher);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void delete(int teacherID) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.delete(this.getTeacher(teacherID));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void update(TeacherEntity teacher) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(teacher);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<TeacherEntity> getTeacher(int teacherID) {
        Session session = getCurrentSession();
        List<TeacherEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<TeacherEntity>) session.createQuery("from TeacherEntity where id = :number").setParameter("number",teacherID).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public List<TeacherEntity> getTeacher(String teacherName) {
        Session session = getCurrentSession();
        List<TeacherEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<TeacherEntity>) session.createQuery("from TeacherEntity where name = :name").setParameter("name",teacherName).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public TeacherEntity listToTeacher(List<TeacherEntity> teacherList) {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(teacherList.get(0).getId());
        teacher.setName(teacherList.get(0).getName());
        return teacher;
    }
}
