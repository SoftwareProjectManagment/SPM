package com.dao;

import com.entity.TeacherEntity;
import com.entity.TeamEntity;

import java.util.List;

/**
 * Created by Java on 2016/3/14.
 */
public interface TeacherDao {
    void insert(TeacherEntity teacher);

    void delete(int teacherID);

    void update(TeacherEntity teacher);

    public List<TeacherEntity> getTeacher(int teacherID);

    public List<TeacherEntity> getTeacher(String teacherName);

    public TeacherEntity listToTeacher(List<TeacherEntity> teacherList);

}
