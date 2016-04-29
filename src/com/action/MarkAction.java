package com.action;

import com.entity.TeamEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TeamManagerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Java on 2016/4/20.
 */
public class MarkAction extends ActionSupport {

    private TeamManagerImpl teamManager;

    private String chooseTeam;

    private String deploypoint;

    public TeamManagerImpl getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerImpl teamManager) {
        this.teamManager = teamManager;
    }

    public String getChooseTeam() {
        return chooseTeam;
    }

    public void setChooseTeam(String chooseTeam) {
        this.chooseTeam = chooseTeam;
    }

    public String getDeploypoint() {
        return deploypoint;
    }

    public void setDeploypoint(String deploypoint) {
        this.deploypoint = deploypoint;
    }

    /*public String validateMark() {

        System.out.println("v当前chooseTeam为" + chooseTeam);
        if (chooseTeam == null || chooseTeam.trim().equals(""))
        {
            System.out.println("未通过验证");

            addFieldError("test","请选择一个小组");

            return INPUT;
        }else{

            this.mark();

            return SUCCESS;
        }
    }*/


    public String mark() {

        System.out.println("e当前chooseTeam为" + chooseTeam);

        Map<String,Object> session = ActionContext.getContext().getSession();

        if( chooseTeam!= null || chooseTeam.trim().equals("")){
            int teamToMark = Integer.parseInt(chooseTeam);
            System.out.println("后台接受到的小组号为" + teamToMark);

            TeamEntity team = teamManager.listToTeam(teamManager.getTeam(teamToMark));

            session.put("team", team);

            chooseTeam = null;

            return SUCCESS;

        }else{

            return INPUT;

        }

    }

    public String submit(){

            Map<String,Object> session = ActionContext.getContext().getSession();

            int newdeployscore = Integer.parseInt(deploypoint);

            TeamEntity team = (TeamEntity) session.get("team");

            team.setDeploytest(newdeployscore);

            teamManager.insert(team);

            session.put("team", team);

            return SUCCESS;

    }


}
