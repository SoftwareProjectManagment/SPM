package main.java.bupt.dao;

import main.java.bupt.domain.Admin;

import java.util.List;

/**
 * Created by Java on 2016/4/3.
 */
public interface AdminDao {
    void insert(Admin admin);

    void delete(int adminID);

    void update(Admin admin);

    public List<Admin> getAdmin(int adminID);

    public Admin listToAdmin(List<Admin> adminList);

}
