package com.dao;

import com.entity.StudentEntity;
import com.entity.TeamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TeamDaoImpl implements TeamDao{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void insert(TeamEntity team) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(team);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void delete(int teamNumber) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.delete(this.getTeam(teamNumber));
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void update(TeamEntity team) {
        Session session = getCurrentSession();
        Transaction tx =  session.beginTransaction();
        try{
            session.saveOrUpdate(team);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<TeamEntity> getTeam(int teamNumber) {
        Session session = getCurrentSession();
        List<TeamEntity> result = new ArrayList<>();
        Transaction tx =  session.beginTransaction();
        try{
            result = (List<TeamEntity>) session.createQuery("from TeamEntity where id = :number").setParameter("number",teamNumber).list();
            tx.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            return result;
        }
    }

    @Override
    public TeamEntity listToTeam(List<TeamEntity> teamList) {
        TeamEntity team = new TeamEntity();
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
    public String updateTeamMember(int teamNumber, StudentEntity student) {
        List<TeamEntity> teamsList = getTeam(teamNumber);
        TeamEntity teamToUpdate = listToTeam(teamsList);
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
    public int digitToNum(int teamNum, int digit) {
        TeamEntity team = listToTeam(getTeam(teamNum));
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
    public String deleteStudent(int teamNum, int studentNum) {
        TeamEntity team = listToTeam(getTeam(teamNum));
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

   /* @Override
    public TeamEntity getTeamInfo(int teamNumber) {

    }*/
}
