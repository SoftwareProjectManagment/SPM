package main.java.bupt.service;

import main.java.bupt.dao.AdminDao;
import main.java.bupt.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Java on 2016/4/3.
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional
    public void insert(Admin admin) {
        adminDao.insert(admin);
    }

    @Override
    @Transactional
    public void delete(int adminID) {
        adminDao.delete(adminID);
    }

    @Override
    @Transactional
    public void update(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    @Transactional
    public List<Admin> getAdmin(int adminID) {
        return adminDao.getAdmin(adminID);
    }

    @Override
    public Admin listToAdmin(List<Admin> adminList) {
        return adminDao.listToAdmin(adminList);
    }
}
