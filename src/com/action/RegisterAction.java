package com.action;

import com.form.UserForm;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserManagerImpl;

/**
 * Created by Java on 2016/4/18.
 */
public class RegisterAction extends ActionSupport{

    private UserForm userForm;

    private UserManagerImpl userManager;

    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }

    public UserManagerImpl getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    @Override
    public String execute() throws Exception {
        try{
            userManager.regUser(userForm);
            return SUCCESS;
        }
        catch(Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }
}
