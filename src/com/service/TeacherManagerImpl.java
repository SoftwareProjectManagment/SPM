package com.service;

import com.dao.TeacherDao;
import com.dao.TeamDao;
import com.entity.TeacherEntity;

import java.util.List;

/**
 * Created by Java on 2016/4/18.
 */
public class TeacherManagerImpl {

    private TeacherDao teacherDao;

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void insert(TeacherEntity teacher) {
        teacherDao.insert(teacher);
    }

    public void delete(int teacherID) {
        teacherDao.delete(teacherID);
    }

    public void update(TeacherEntity teacher) {
        teacherDao.update(teacher);
    }

    public List<TeacherEntity> getTeacher(int teacherID) {
        return teacherDao.getTeacher(teacherID);
    }

    public List<TeacherEntity> getTeacher(String teacherName){
        return teacherDao.getTeacher(teacherName);
    }

    public TeacherEntity listToTeacher(List<TeacherEntity> teacherList) {
        return teacherDao.listToTeacher(teacherList);
    }

}
