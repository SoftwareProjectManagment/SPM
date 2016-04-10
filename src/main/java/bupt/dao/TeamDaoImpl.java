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

    @Override
    public List<Team> getTeam(int teamNumber) {
        return (List<Team>) sessionFactory.getCurrentSession().createQuery("from Team where teamnumber = :number").setParameter("number",teamNumber).list();
    }
}
