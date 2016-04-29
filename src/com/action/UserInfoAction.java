package com.action;

import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentManagerImpl;
import com.service.TeamManagerImpl;
import com.service.UserManagerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Java on 2016/4/28.
 */
public class UserInfoAction extends ActionSupport{

    private UserManagerImpl userManager;
    private TeamManagerImpl teamManager;
    private StudentManagerImpl studentManager;
    private String newNumber;
    private String newName;
    private String newPassword;
    private String newIdentity;
    private String chooseUser;

    public String getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(String newNumber) {
        this.newNumber = newNumber;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewIdentity() {
        return newIdentity;
    }

    public void setNewIdentity(String newIdentity) {
        this.newIdentity = newIdentity;
    }

    public String getChooseUser() {
        return chooseUser;
    }

    public void setChooseUser(String chooseUser) {
        this.chooseUser = chooseUser;
    }

    public UserManagerImpl getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    public TeamManagerImpl getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerImpl teamManager) {
        this.teamManager = teamManager;
    }

    public StudentManagerImpl getStudentManager() {
        return studentManager;
    }

    public void setStudentManager(StudentManagerImpl studentManager) {
        this.studentManager = studentManager;
    }

    public String userInfo(){
       List<UserEntity> allUser =  userManager.getExistUser();
        Map<String,Object> session = ActionContext.getContext().getSession();
        session.put("userList",allUser);
        return SUCCESS;
    }

    public String modifyUser(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        List<UserEntity> allUser = (List<UserEntity>)session.get("userList");

        String modifyUserNum[] = new String[100];
        String modifyUserName[] = new String[100];
        String modifyUserPassword[] = new String[100];
        String modifyUserID[] = new String[100];

        for(int i = 1; i <= allUser.size() ; i++){
            HttpServletRequest request= ServletActionContext.getRequest();
            modifyUserNum[i] = request.getParameter("number"+i);
            if (modifyUserNum[i]==null){
                continue;
            }
            modifyUserName[i] = request.getParameter("name"+i);
            modifyUserPassword[i] = request.getParameter("password"+i);
            modifyUserID[i] = request.getParameter("identity"+i);
            if(userManager.checkuserExist(Integer.parseInt(modifyUserNum[i])).equals("exist")){
                UserEntity userEntity = userManager.getUser(Integer.parseInt(modifyUserNum[i]));
                String username = modifyUserName[i];
                String password = modifyUserPassword[i];
                String ID = modifyUserID[i];

                if(username!=null){
                    userEntity.setUsername(username);
                }
                if(password!=null){
                    userEntity.setPassword(password);
                }
                if(ID!=null){
                    userEntity.setIdentity(ID);
                }
                userManager.insert(userEntity);
            }
        }
        List<UserEntity> userlist = userManager.getExistUser();
        session.put("userList",userlist);
        return SUCCESS;
    }
    public String addUser(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        int newID = Integer.parseInt(newNumber);
        UserEntity newuser = new UserEntity(newID,newName,newPassword,newIdentity);
        if(userManager.checkuserExist(Integer.parseInt(newNumber)).equals("notExist")){
            userManager.insert(newuser);
        }
        List<UserEntity> userlist = userManager.getExistUser();
        session.put("userList",userlist);
        return SUCCESS;
    }

    public String deleteUser(){

        Map<String,Object> session = ActionContext.getContext().getSession();

        int chooseUserID = Integer.parseInt(chooseUser);

        UserEntity chooseUser = userManager.getUser(chooseUserID);

        if (chooseUserID == 0){

        }else if(!chooseUser.getIdentity().equals("student")){
            UserEntity todelete = userManager.getUser(chooseUserID);
            userManager.deleteUser(todelete);

        }else{
            UserEntity todelete = userManager.getUser(chooseUserID);
            userManager.deleteUser(todelete);
            int studentNum = studentManager.getStudent(chooseUser.getUsername()).get(0).getId();
            int teamNum =studentManager.getStudent(chooseUser.getUsername()).get(0).getGroupnum();
            teamManager.deleteStudent(teamNum,studentNum);

        }
        List<UserEntity> userlist = userManager.getExistUser();
        session.put("userList",userlist);
        return SUCCESS;
    }

}
