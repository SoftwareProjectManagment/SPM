package main.java.bupt.service;

import main.java.bupt.dao.UserDao;
import main.java.bupt.domain.Student;
import main.java.bupt.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Java on 2016/3/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    @Transactional
    public void delete(int userID) {
        userDao.delete(userID);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public List<User> getUser(int userID) {
        return userDao.getUser(userID);
    }

    @Override
    public User listToUser(List<User> userList) {
        return userDao.listToUser(userList);
    }

    @Override
    @Transactional
    public String checkUserExist(Student student) {
        return userDao.checkUserExist(student);
    }

    @Override
    @Transactional
    public String insertStudent(Student student) {
        return userDao.insertStudent(student);
    }
}
