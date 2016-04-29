package com.dao;

import com.entity.StudentEntity;
import com.entity.UserEntity;

import java.util.List;

public interface UserDao {
    void insert(UserEntity user);

    void delete(UserEntity userEntity);

    void update(UserEntity user);

    public List<UserEntity> getUser(int UserID);

    public List<UserEntity> getUser(String userName);

    public UserEntity listToUser(List<UserEntity> userList);

    public String checkUserExist(StudentEntity studentEntity);

    public String checkuserExist(int userID);

    public String insertStudent(StudentEntity studentEntity);

    public List<UserEntity> getAllUser();
}
