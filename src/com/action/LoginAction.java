package com.action;

import com.entity.AdminEntity;
import com.entity.StudentEntity;
import com.entity.TeacherEntity;
import com.entity.TeamEntity;
import com.form.UserForm;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Java on 2016/4/18.
 */
public class LoginAction extends ActionSupport {

    private String message;
    private UserForm userForm;
    private AdminManagerImpl adminManager;
    private StudentManagerImpl studentManager;
    private TeacherManagerImpl teacherManager;
    private TeamManagerImpl teamManager;
    private UserManagerImpl userManager;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }

    public AdminManagerImpl getAdminManager() {
        return adminManager;
    }

    public void setAdminManager(AdminManagerImpl adminManager) {
        this.adminManager = adminManager;
    }

    public StudentManagerImpl getStudentManager() {
        return studentManager;
    }

    public void setStudentManager(StudentManagerImpl studentManager) {
        this.studentManager = studentManager;
    }

    public TeacherManagerImpl getTeacherManager() {
        return teacherManager;
    }

    public void setTeacherManager(TeacherManagerImpl teacherManager) {
        this.teacherManager = teacherManager;
    }

    public TeamManagerImpl getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerImpl teamManager) {
        this.teamManager = teamManager;
    }

    public UserManagerImpl getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    @Override
    public String execute() throws Exception {

        Map<String, Object> session =  ActionContext.getContext().getSession();

        try{
            if(userManager.login(userForm).equals("teacher")){
                //int teacherID = userForm.getId();
                String teacherName = userForm.getUsername();
                TeacherEntity loginTeacher = teacherManager.getTeacher(teacherName).get(0);
                List<TeamEntity> teamList = teamManager.getExistTeam();
                session.put("loginTeacher", loginTeacher);//存入登入教师
                session.put("teamList",teamList);
                message = "success";
                return "teacher";
            }else if(userManager.login(userForm).equals("student")){
                String name = userForm.getUsername();
                StudentEntity loginStudent = studentManager.getStudent(name).get(0);
                System.out.println("登陆姓名:" + loginStudent.getName());
                session.put("loginStudent", loginStudent);
                message = "success";
                return "student";
            }else if(userManager.login(userForm).equals("admin")){
                String name = userForm.getUsername();
                AdminEntity loginAdmin = adminManager.getAdmin(name).get(0);
                //System.out.println();
                session.put("loginAdmin",loginAdmin);
                message = "success";
                return "admin";
            }else{
                message = "登陆失败";
                return ERROR;
            }
    }catch(Exception e){
            e.printStackTrace();
            message = "登陆失败";
            return ERROR;
        }
    }
}
