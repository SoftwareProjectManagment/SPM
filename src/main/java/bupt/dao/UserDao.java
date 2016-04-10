package main.java.bupt.dao;

import main.java.bupt.domain.Student;
import main.java.bupt.domain.User;

import java.util.List;

/**
 * Created by Java on 2016/3/24.
 */
public interface UserDao {
    void insert(User user);

    void delete(int userID);

    void update(User user);

    public List<User> getUser(int userID);

    public User listToUser(List<User> userList);

    public String checkUserExist(Student student);

    public String insertStudent(Student student);

}
