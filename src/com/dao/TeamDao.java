package com.dao;

import com.entity.StudentEntity;
import com.entity.TeamEntity;

import java.util.List;

/**
 * Created by Java on 2016/3/11.
 */
public interface TeamDao {
    void insert(TeamEntity team);

    void delete(int teamNumber);

    void update(TeamEntity team);

    public List<TeamEntity> getTeam(int teamNumber);

    public TeamEntity listToTeam(List<TeamEntity> teamList);

    public String updateTeamMember(int teamNumber, StudentEntity student);

    public int digitToNum(int teamNum, int digit);

    public String deleteStudent(int teamNum, int studentNum);

    //public TeamEntity getTeamInfo(int teamNumber);

}
