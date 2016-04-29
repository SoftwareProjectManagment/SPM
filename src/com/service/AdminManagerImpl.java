package com.service;

import com.dao.AdminDao;
import com.entity.AdminEntity;

import java.util.List;

/**
 * Created by Java on 2016/4/18.
 */
public class AdminManagerImpl {

    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public void update(AdminEntity admin) {
        adminDao.update(admin);
    }

    public List<AdminEntity> getAdmin(int adminID) {
        return adminDao.getAdmin(adminID);
    }

    public List<AdminEntity> getAdmin(String adminName){
        return adminDao.getAdmin(adminName);
    }

    public AdminEntity listToAdmin(List<AdminEntity> adminList) {
        return adminDao.listToAdmin(adminList);
    }

}
