package com.dao;


import com.entity.AdminEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
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
    public void insert(AdminEntity admin) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(admin);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void delete(int adminID) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.delete(this.getAdmin(adminID));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void update(AdminEntity admin) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(admin);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<AdminEntity> getAdmin(int adminID) {
        Session session = getCurrentSession();
        List<AdminEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<AdminEntity>) session.createQuery("from AdminEntity where id = :number").setParameter("number",adminID).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public List<AdminEntity> getAdmin(String adminName) {
        Session session = getCurrentSession();
        List<AdminEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<AdminEntity>) session.createQuery("from AdminEntity where name = :name").setParameter("name",adminName).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public AdminEntity listToAdmin(List<AdminEntity> adminList) {
        AdminEntity admin = new AdminEntity();
        admin.setId(adminList.get(0).getId());
        admin.setName(adminList.get(0).getName());
        return admin;
    }
}
