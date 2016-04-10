package main.java.bupt.dao;

import main.java.bupt.domain.Student;
import main.java.bupt.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Java on 2016/3/24.
 */
@Repository
@SessionScoped
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(User user) {
        sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void delete(int userID) {
        sessionFactory.getCurrentSession().delete(this.getUser(userID));
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public List<User> getUser(int userID) {
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User where id = :number").setParameter("number",userID).list();
    }

    @Override
    public User listToUser(List<User> userList) {
        User user = new User();
        user.setId(userList.get(0).getId());
        user.setUsername(userList.get(0).getUsername());
        user.setPassword(userList.get(0).getPassword());
        user.setIdentity(userList.get(0).getIdentity());
        return user;
    }


    @Override
    public String checkUserExist(Student student) {
        int studentID = student.getId();
        List<User> users = getUser(studentID);
        if (users.isEmpty()){
            return "notExist";
        }
        else{
            return "exist";
        }
    }

    @Override
    public String insertStudent(Student student) {
        int studentID = student.getId();
        String userName = student.getName();
        User user = new User(studentID,userName,"1","student");
        insert(user);
        return "success";
    }
}
