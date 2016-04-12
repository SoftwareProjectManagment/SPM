package main.java.bupt.service;

import main.java.bupt.dao.TeamDao;
import main.java.bupt.domain.Student;
import main.java.bupt.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Java on 2016/3/11.
 */
@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamDao teamDao;

    @Override
    @Transactional
    public void insert(Team team) {
        teamDao.insert(team);
    }

    @Override
    @Transactional
    public void delete(int teamNumber) {
        teamDao.delete(teamNumber);
    }

    @Override
    @Transactional
    public void update(Team team) {
        teamDao.update(team);
    }

    @Override
    @Transactional
    public List<Team> getTeam(int teamNumber) {
        return teamDao.getTeam(teamNumber);
    }

    @Override
    public Team listToTeam(List<Team> teamList){
        return teamDao.listToTeam(teamList);
    }

    @Override
    @Transactional
    public String updateTeamMember(int teamNumber, Student student) {
        return teamDao.updateTeamMember(teamNumber,student);
    }

    @Override
    @Transactional
    public int digitToNum(int teamNum, int digit) {
        return teamDao.digitToNum(teamNum,digit);
    }

    @Override
    @Transactional
    public String deleteStudent(int teamNum, int studentNum) {
        return teamDao.deleteStudent(teamNum,studentNum);
    }


}
