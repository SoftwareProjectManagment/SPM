package com.dao;

import com.entity.StudentEntity;
import com.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Java on 2016/4/18.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
        //return sessionFactory.openSession();
    }
    @Override
    public void insert(UserEntity user) {
        //sessionFactory.getCurrentSession().clear();
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(user);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    /*@Override
    @Transactional
    public void insert(UserEntity user){
        getCurrentSession().saveOrUpdate(user);
    }*/

    @Override
    public void delete(UserEntity userEntity) {
        Session session = getCurrentSession();

        Transaction tx =  session.beginTransaction();
        try{
            session.delete(userEntity);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void update(UserEntity user) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(user);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<UserEntity> getUser(int userID) {
        Session session = getCurrentSession();
        List<UserEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<UserEntity>) session.createQuery("from UserEntity where id = :number").setParameter("number",userID).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public List<UserEntity> getUser(String userName) {
        Session session = getCurrentSession();
        List<UserEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<UserEntity>) session.createQuery("from UserEntity where username = :name").setParameter("name",userName).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public UserEntity listToUser(List<UserEntity> userList) {
        UserEntity user = new UserEntity();
        user.setId(userList.get(0).getId());
        user.setUsername(userList.get(0).getUsername());
        user.setPassword(userList.get(0).getPassword());
        user.setIdentity(userList.get(0).getIdentity());
        return user;
    }

    @Override
    public String checkUserExist(StudentEntity studentEntity) {

        List<UserEntity> users = getUser(studentEntity.getId());
        if (users.isEmpty()){
            return "notExist";
        }
        else{
            return "exist";
        }
    }

    @Override
    public String checkuserExist(int userID) {
        List<UserEntity> users = getUser(userID);
        if (users.isEmpty()){
            return "notExist";
        }
        else{
            return "exist";
        }
    }


    @Override
    public String insertStudent(StudentEntity studentEntity) {
        int studentID = studentEntity.getId();
        String userName = studentEntity.getName();
        UserEntity user = new UserEntity(studentID,userName,"1","student");
        insert(user);
        return "success";
    }

    @Override
    public List<UserEntity> getAllUser() {
        Session session = getCurrentSession();
        List<UserEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<UserEntity>) session.createQuery("from UserEntity").list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }
}
