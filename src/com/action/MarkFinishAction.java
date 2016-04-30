package com.action;

import com.entity.TeamEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TeamManagerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Java on 2016/4/29.
 */
public class MarkFinishAction extends ActionSupport {

    private TeamManagerImpl teamManager;

    public TeamManagerImpl getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerImpl teamManager) {
        this.teamManager = teamManager;
    }

    public String execute(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        List<TeamEntity> teamList = teamManager.getExistTeam();
        session.put("teamList",teamList);
        return SUCCESS;
    }

}
