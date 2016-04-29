package com.service;

import com.dao.UserDao;
import com.entity.StudentEntity;
import com.entity.UserEntity;
import com.form.UserForm;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Java on 2016/4/18.
 */
public class UserManagerImpl {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert(UserEntity userEntity){
        userDao.insert(userEntity);
    }
    public void regUser(UserForm userForm){
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userForm,user);
        userDao.insert(user);
    }

    public String login(UserForm userForm){
        UserEntity user = new UserEntity();
        if(userForm!=null){
            BeanUtils.copyProperties(userForm,user);
            List<UserEntity> result = userDao.getUser(user.getUsername());
            if(result.isEmpty()){
                return "false";
            }else if(result.get(0).getPassword().equals(userForm.getPassword())){
                if(result.get(0).getIdentity().equals("teacher")){
                    return "teacher";
                }else if(result.get(0).getIdentity().equals("student")){
                    return "student";
                }else{
                    return "admin";
                }
            }else{
                return "false";
            }
        }else{
            return "false";
        }
    }

    public String checkUserExist(StudentEntity studentEntity) {
        return userDao.checkUserExist(studentEntity);
    }
    public String insertStudent(StudentEntity studentEntity){
        return userDao.insertStudent(studentEntity);
    }

    public List<UserEntity> getExistUser(){

        List<UserEntity> result = userDao.getAllUser();

        return result;
    }
    public String checkuserExist(int userID){
        return userDao.checkuserExist(userID);
    }

    public UserEntity getUser(int userID){
        return userDao.listToUser(userDao.getUser(userID));
    }

    public void deleteUser(UserEntity userEntity){
        userDao.delete(userEntity);
    }
}
