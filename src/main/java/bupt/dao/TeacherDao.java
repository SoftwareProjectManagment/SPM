package main.java.bupt.dao;

import main.java.bupt.domain.Teacher;

import java.util.List;

/**
 * Created by Java on 2016/3/14.
 */
public interface TeacherDao {
    void insert(Teacher teacher);

    void delete(int teacherID);

    void update(Teacher teacher);

    public List<Teacher> getTeacher(int teacherID);

    public Teacher listToTeacher(List<Teacher> teacherList);
}
