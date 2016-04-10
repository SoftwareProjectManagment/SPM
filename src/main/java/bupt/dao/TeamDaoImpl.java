package main.java.bupt.dao;

import main.java.bupt.domain.Team;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Java on 2016/3/11.
 */
@Repository
@SessionScoped
public class TeamDaoImpl implements TeamDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Team team) {
        sessionFactory.getCurrentSession().saveOrUpdate(team);
    }

    @Override
    public void delete(int teamNumber) {
        sessionFactory.getCurrentSession().delete(this.getTeam(teamNumber));
    }

    @Override
    public void update(Team team) {
        sessionFactory.getCurrentSession().saveOrUpdate(team);
    }

    public List<Team> getTeam(int teamNumber) {
        return (List<Team>) sessionFactory.getCurrentSession().createQuery("from Team where id = :number").setParameter("number",teamNumber).list();
    }

    @Override
    public Team listToTeam(List<Team> teamList) {
        Team team = new Team();
        team.setId(teamList.get(0).getId());
        team.setDeploytest(teamList.get(0).getDeploytest());
        team.setFrontpagetest(teamList.get(0).getFrontpagetest());
        team.setFunctiontest(teamList.get(0).getFunctiontest());
        team.setPerformancetest(teamList.get(0).getPerformancetest());
        team.setCodetestone(teamList.get(0).getCodetestone());
        team.setCodetestwo(teamList.get(0).getCodetestwo());
        team.setDocumentest(teamList.get(0).getDocumentest());
        team.setFilename(teamList.get(0).getFilename());
        team.setIpaddress(teamList.get(0).getIpaddress());
        return team;
    }
}
