package com.dao;


import com.entity.AdminEntity;

import java.util.List;

public interface AdminDao {
    void insert(AdminEntity admin);

    void delete(int adminID);

    void update(AdminEntity admin);

    public List<AdminEntity> getAdmin(int adminID);

    public List<AdminEntity> getAdmin(String adminName);

    public AdminEntity listToAdmin(List<AdminEntity> adminList);

}
