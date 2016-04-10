package main.java.bupt.dao;

import main.java.bupt.domain.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Java on 2016/4/3.
 */
@Repository
@SessionScoped
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Admin admin) {
        sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().saveOrUpdate(admin);
    }

    @Override
    public void delete(int adminID) {
        sessionFactory.getCurrentSession().delete(this.getAdmin(adminID));
    }

    @Override
    public void update(Admin admin) {
        sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().saveOrUpdate(admin);
    }

    @Override
    public List<Admin> getAdmin(int adminID) {
        return (List<Admin>) sessionFactory.getCurrentSession().createQuery("from Admin where id = :number").setParameter("number",adminID).list();
    }

    @Override
    public Admin listToAdmin(List<Admin> adminList) {
        Admin admin = new Admin();
        admin.setId(adminList.get(0).getId());
        admin.setName(adminList.get(0).getName());
        return admin;
    }
}
