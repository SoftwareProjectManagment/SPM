package com.action;

import com.entity.StudentEntity;
import com.entity.TeamEntity;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentManagerImpl;
import com.service.TeacherManagerImpl;
import com.service.TeamManagerImpl;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Java on 2016/4/19.
 */
public class DeployAction extends ActionSupport {

    private File file;

    private String fileFileName;

    private String fileContentType;

    private String IPaddress;

    private TeamManagerImpl teamManager;


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getIPaddress() {
        return IPaddress;
    }

    public void setIPaddress(String IPaddress) {
        this.IPaddress = IPaddress;
    }

    public TeamManagerImpl getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerImpl teamManager) {
        this.teamManager = teamManager;
    }

    public String deploy() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<TeamEntity> teamList = teamManager.getTeam(3);

        String filename = teamList.get(0).getFilename();
        String IPaddress = teamList.get(0).getIpaddress();

        int checkFunction = teamList.get(0).getFunctiontest();
        int checkFrontPage = teamList.get(0).getFrontpagetest();
        int checkPerformance = teamList.get(0).getPerformancetest();
        int checkCodeOne = teamList.get(0).getCodetestone();
        int checkCodeTwo = teamList.get(0).getCodetestwo();
        int checkDocument = teamList.get(0).getDocumentest();

        System.out.println("初次信息:"+ filename + IPaddress + checkFunction + checkFrontPage +checkPerformance);
        session.put("deployedFile",filename);
        session.put("deployedIP",IPaddress);
        session.put("checkFunction",checkFunction);
        session.put("checkFrontPage",checkFrontPage);
        session.put("checkDocument",checkDocument);
        session.put("checkCodeOne",checkCodeOne);
        session.put("checkCodeTwo",checkCodeTwo);
        session.put("checkPerformance",checkPerformance);

        return SUCCESS;
    }

    public String upLoadFile() throws Exception {

        System.out.println("文件名:"+fileFileName);

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<TeamEntity> teamList = teamManager.getTeam(3);

        TeamEntity team = teamManager.listToTeam(teamList);

        team.setFilename(fileFileName);

        team.setIpaddress(IPaddress);

        teamManager.update(team);

        System.out.println("文件名:"+fileFileName);

        String destpath = "C:/upLoadFile/";
        try{
            File destFile = new File(destpath,fileFileName);
            FileUtils.copyFile(file,destFile);
        }catch(Exception e){
            e.printStackTrace();
        }

        //do deploy,文件保存在"C:/upLoadFile"

        List<TeamEntity> teamListAgain = teamManager.getTeam(3);

        session.put("deployedFile",fileFileName);
        session.put("deployedIP",IPaddress);

        return SUCCESS;
    }


    public String checkCode() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<TeamEntity> teamList = teamManager.getTeam(3);

        TeamEntity team = teamManager.listToTeam(teamList);

        team.setCodetestone(-2);

        team.setCodetestwo(-2);

        teamManager.update(team);

        List<TeamEntity> teamListAgain = teamManager.getTeam(3);

        session.put("checkCodeOne",teamListAgain.get(0).getCodetestone());

        session.put("checkCodeTwo",teamListAgain.get(0).getCodetestwo());

        return SUCCESS;
    }

    public String checkDocument() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<TeamEntity> teamList = teamManager.getTeam(3);

        TeamEntity team = teamManager.listToTeam(teamList);

        team.setDocumentest(-2);

        teamManager.update(team);

        List<TeamEntity> teamListAgain = teamManager.getTeam(3);

        session.put("checkDocument",teamListAgain.get(0).getDocumentest());

        return SUCCESS;
    }

    public String checkPerformance() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<TeamEntity> teamList = teamManager.getTeam(3);

        TeamEntity team = teamManager.listToTeam(teamList);

        //do performance examination

        team.setPerformancetest(-2);

        teamManager.update(team);

        List<TeamEntity> teamListAgain = teamManager.getTeam(3);

        session.put("checkPerformance",teamListAgain.get(0).getPerformancetest());

        return SUCCESS;
    }

    public String checkFunction() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<TeamEntity> teamList = teamManager.getTeam(3);

        TeamEntity team = teamManager.listToTeam(teamList);

        //do function examination

        team.setFunctiontest(-2);

        teamManager.update(team);

        List<TeamEntity> teamListAgain = teamManager.getTeam(3);

        session.put("checkFunction",teamListAgain.get(0).getFunctiontest());

        return SUCCESS;
    }

    public String checkFrontPage() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        List<TeamEntity> teamList = teamManager.getTeam(3);

        TeamEntity team = teamManager.listToTeam(teamList);

        //do frontpage examination

        team.setFrontpagetest(-2);

        teamManager.update(team);

        List<TeamEntity> teamListAgain = teamManager.getTeam(3);

        session.put("checkFrontPage",teamListAgain.get(0).getFrontpagetest());

        return SUCCESS;
    }
}
