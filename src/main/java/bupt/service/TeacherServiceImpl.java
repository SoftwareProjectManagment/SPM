package main.java.bupt.service;

import main.java.bupt.dao.TeacherDao;
import main.java.bupt.dao.TeamDao;
import main.java.bupt.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Java on 2016/3/14.
 */
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    @Transactional
    public void insert(Teacher teacher) {
        teacherDao.insert(teacher);
    }

    @Override
    @Transactional
    public void delete(int teacherID) {
        teacherDao.delete(teacherID);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    @Transactional
    public List<Teacher> getTeacher(int teacherID) {
        return teacherDao.getTeacher(teacherID);
    }

    @Override
    @Transactional
    public Teacher listToTeacher(List<Teacher> teacherList) {
        return teacherDao.listToTeacher(teacherList);
    }
}
