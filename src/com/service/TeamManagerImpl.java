package com.service;

import com.dao.TeamDao;
import com.entity.StudentEntity;
import com.entity.TeamEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Java on 2016/4/18.
 */
public class TeamManagerImpl {

    private TeamDao teamDao;

    public TeamDao getTeamDao() {
        return teamDao;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void insert(TeamEntity team) {
        teamDao.insert(team);
    }

    public void delete(int teamNumber) {
        teamDao.delete(teamNumber);
    }

    public void update(TeamEntity team) {
        teamDao.update(team);
    }

    public List<TeamEntity> getTeam(int teamNumber) {
        return teamDao.getTeam(teamNumber);
    }

    public TeamEntity listToTeam(List<TeamEntity> teamList){
        return teamDao.listToTeam(teamList);
    }

    public String updateTeamMember(int teamNumber, StudentEntity student) {
        return teamDao.updateTeamMember(teamNumber,student);
    }

    public int digitToNum(int teamNum, int digit) {
        return teamDao.digitToNum(teamNum,digit);
    }

    public String deleteStudent(int teamNum, int studentNum) {
        return teamDao.deleteStudent(teamNum,studentNum);
    }

    public List<TeamEntity> getExistTeam(){
        List<TeamEntity> teamList = null;
        for (int i=1;i<=22;i++){
            List<TeamEntity> tempTeamList = this.getTeam(i);
            if (!tempTeamList.isEmpty()){
                TeamEntity tempTeam = this.listToTeam(tempTeamList);
                if (teamList == null){
                    teamList = tempTeamList;
                }
                else{
                    teamList.add(tempTeam);
                }
            }
        }
        if (teamList == null){
            teamList = this.getTeam(0);
        }
        return teamList;
    }

    public List<Integer> getNoneExist(){
        List<Integer> noRegisterList = new ArrayList<>();
        for (int i=1;i<=22;i++){
            List<TeamEntity> tempTeamList = this.getTeam(i);
            if (tempTeamList.isEmpty()){
                noRegisterList.add(i);
            }
        }
        return noRegisterList;
    }
}
