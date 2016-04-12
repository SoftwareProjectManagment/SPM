package main.java.bupt.dao;

import main.java.bupt.domain.Student;
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
        sessionFactory.getCurrentSession().clear();
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
        team.setMemberOne(teamList.get(0).getMemberOne());
        team.setMemberTwo(teamList.get(0).getMemberTwo());
        team.setMemberThree(teamList.get(0).getMemberThree());
        team.setMemberFour(teamList.get(0).getMemberFour());
        team.setMemberFive(teamList.get(0).getMemberFive());
        team.setMemberSix(teamList.get(0).getMemberSix());
        team.setPcaseOne(teamList.get(0).getPcaseOne());
        team.setPcaseTwo(teamList.get(0).getPcaseTwo());
        team.setPcaseThree(teamList.get(0).getPcaseThree());
        team.setPcaseFour(teamList.get(0).getPcaseFour());
        team.setPcaseFive(teamList.get(0).getPcaseFive());
        team.setFcaseOne(teamList.get(0).getFcaseOne());
        team.setFcaseTwo(teamList.get(0).getFcaseTwo());
        team.setFcaseThree(teamList.get(0).getFcaseThree());
        team.setFcaseFour(teamList.get(0).getFcaseFour());
        team.setFcaseFive(teamList.get(0).getFcaseFive());
        return team;
    }

    @Override
    public String updateTeamMember(int teamNumber, Student student) {
        List<Team> teamsList = getTeam(teamNumber);
        Team teamToUpdate = listToTeam(teamsList);
        if (teamToUpdate.getMemberOne()==-1){
            teamToUpdate.setMemberOne(student.getId());
            insert(teamToUpdate);
        }
        else if (teamToUpdate.getMemberTwo()==-1){
            teamToUpdate.setMemberTwo(student.getId());
            insert(teamToUpdate);
        }
        else if (teamToUpdate.getMemberThree()==-1){
            teamToUpdate.setMemberThree(student.getId());
            insert(teamToUpdate);
        }
        else if (teamToUpdate.getMemberFour()==-1){
            teamToUpdate.setMemberFour(student.getId());
            insert(teamToUpdate);
        }
        else if (teamToUpdate.getMemberFive()==-1){
            teamToUpdate.setMemberFive(student.getId());
            insert(teamToUpdate);
        }
        else if (teamToUpdate.getMemberSix()==-1){
            teamToUpdate.setMemberSix(student.getId());
            insert(teamToUpdate);
        }
        else{
            return "fullMember";
        }
        return "success";
    }

    @Override
    public int digitToNum(int teamNum,int digit) {
        Team team = listToTeam(getTeam(teamNum));
        if (digit==1){
            return team.getMemberOne();
        }
        else if (digit==2){
            return team.getMemberTwo();
        }
        else if (digit==3){
            return team.getMemberThree();
        }
        else if (digit==4){
            return team.getMemberFour();
        }
        else if (digit==5){
            return team.getMemberFive();
        }
        else if (digit==6){
            return team.getMemberSix();
        }
        return -1;
    }

    @Override
    public String deleteStudent(int teamNum,int studentNum) {
        Team team = listToTeam(getTeam(teamNum));
        if (team.getMemberOne()==studentNum){
            team.setMemberOne(-1);
            insert(team);
            return "success";
        }
        else if (team.getMemberTwo()==studentNum){
            team.setMemberTwo(-1);
            insert(team);
            return "success";
        }
        else if (team.getMemberThree()==studentNum){
            team.setMemberThree(-1);
            insert(team);
            return "success";
        }
        else if (team.getMemberFour()==studentNum){
            team.setMemberFour(-1);
            insert(team);
            return "success";
        }
        else if (team.getMemberFive()==studentNum){
            team.setMemberFive(-1);
            insert(team);
            return "success";
        }
        else if (team.getMemberSix()==studentNum){
            team.setMemberSix(-1);
            insert(team);
            return "success";
        }
        return "fail";
    }
}
