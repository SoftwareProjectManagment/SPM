package com.action;

import com.entity.TeamEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TeamManagerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Java on 2016/4/20.
 */
public class EnrollAction extends ActionSupport {

    private TeamManagerImpl teamManager;

    private int studentOne,studentTwo,studentThree,studentFour,studentFive,studentSix,teamNumber;

    public int getStudentOne() {
        return studentOne;
    }

    public void setStudentOne(int studentOne) {
        this.studentOne = studentOne;
    }

    public int getStudentTwo() {
        return studentTwo;
    }

    public void setStudentTwo(int studentTwo) {
        this.studentTwo = studentTwo;
    }

    public int getStudentThree() {
        return studentThree;
    }

    public void setStudentThree(int studentThree) {
        this.studentThree = studentThree;
    }

    public int getStudentFour() {
        return studentFour;
    }

    public void setStudentFour(int studentFour) {
        this.studentFour = studentFour;
    }

    public int getStudentFive() {
        return studentFive;
    }

    public void setStudentFive(int studentFive) {
        this.studentFive = studentFive;
    }

    public int getStudentSix() {
        return studentSix;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public void setStudentSix(int studentSix) {
        this.studentSix = studentSix;
    }

    public TeamManagerImpl getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerImpl teamManager) {
        this.teamManager = teamManager;
    }

    public String enroll() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<Integer> noRegisterList = teamManager.getNoneExist();

        session.put("noRegisterList",noRegisterList);

        return SUCCESS;
    }

    public String enrollFinish() throws Exception{

        Map<String,Object> session = ActionContext.getContext().getSession();

        TeamEntity team = new TeamEntity(teamNumber,-1,-1,-1,-1,-1,-1,-1,"in:valid","in:valid",studentOne,studentTwo,studentThree,studentFour,studentFive,studentSix);

        teamManager.insert(team);

        List<Integer> noRegisterList = teamManager.getNoneExist();

        session.put("noRegisterList",noRegisterList);

        return SUCCESS;
    }
}
