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
    private String frontpagepoint;
    private String functionpoint;
    private String performancepoint;
    private String codeonepoint;
    private String documentpoint;

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

    public String getFrontpagepoint() {
        return frontpagepoint;
    }

    public void setFrontpagepoint(String frontpagepoint) {
        this.frontpagepoint = frontpagepoint;
    }

    public String getFunctionpoint() {
        return functionpoint;
    }

    public void setFunctionpoint(String functionpoint) {
        this.functionpoint = functionpoint;
    }

    public String getPerformancepoint() {
        return performancepoint;
    }

    public void setPerformancepoint(String performancepoint) {
        this.performancepoint = performancepoint;
    }

    public String getCodeonepoint() {
        return codeonepoint;
    }

    public void setCodeonepoint(String codeonepoint) {
        this.codeonepoint = codeonepoint;
    }

    public String getDocumentpoint() {
        return documentpoint;
    }

    public void setDocumentpoint(String documentpoint) {
        this.documentpoint = documentpoint;
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

    public String submitDeploy(){
            Map<String,Object> session = ActionContext.getContext().getSession();
            int newdeployscore = Integer.parseInt(deploypoint);
            TeamEntity team = (TeamEntity) session.get("team");
            team.setDeploytest(newdeployscore);
            teamManager.insert(team);
            session.put("team", team);
            return SUCCESS;
    }

    public String submitFrontpage(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        int newfrontpagescore = Integer.parseInt(frontpagepoint);
        TeamEntity team = (TeamEntity) session.get("team");
        team.setFrontpagetest(newfrontpagescore);
        teamManager.insert(team);
        session.put("team", team);
        return SUCCESS;
    }

    public String submitFunction(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        int newfunctionscore = Integer.parseInt(functionpoint);
        TeamEntity team = (TeamEntity) session.get("team");
        team.setFunctiontest(newfunctionscore);
        teamManager.insert(team);
        session.put("team", team);
        return SUCCESS;
    }

    public String submitPerformance(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        int newperformancescore = Integer.parseInt(performancepoint);
        TeamEntity team = (TeamEntity) session.get("team");
        team.setPerformancetest(newperformancescore);
        teamManager.insert(team);
        session.put("team", team);
        return SUCCESS;
    }

    public String submitCodeOne(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        int newcodeonescore = Integer.parseInt(codeonepoint);
        TeamEntity team = (TeamEntity) session.get("team");
        team.setCodetestone(newcodeonescore);
        teamManager.insert(team);
        session.put("team", team);
        return SUCCESS;
    }

    public String submitDocument(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        int newdocumentscore = Integer.parseInt(documentpoint);
        TeamEntity team = (TeamEntity) session.get("team");
        team.setDocumentest(newdocumentscore);
        teamManager.insert(team);
        session.put("team", team);
        return SUCCESS;
    }

}
