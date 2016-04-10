package main.java.bupt.dao;

import main.java.bupt.domain.Team;

import java.util.List;

/**
 * Created by Java on 2016/3/11.
 */
public interface TeamDao {
    void insert(Team team);

    void delete(int teamNumber);

    void update(Team team);

    public List<Team> getTeam(int teamNumber);

    public Team listToTeam(List<Team> teamList);

}
