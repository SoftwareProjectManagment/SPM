package com.action;

import com.entity.StudentEntity;
import com.entity.TeamEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentManagerImpl;
import com.service.TeamManagerImpl;
import com.service.UserManagerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Java on 2016/4/20.
 */
public class TeamInfoAction extends ActionSupport {

    private String selectTeamInfo;

    private String chooseStudent;

    private String addStudentNumber;

    private String addStudentName;

    private TeamManagerImpl teamManager;

    private StudentManagerImpl studentManager;

    private UserManagerImpl userManager;

    public String getSelectTeamInfo() {
        return selectTeamInfo;
    }

    public void setSelectTeamInfo(String selectTeamInfo) {
        this.selectTeamInfo = selectTeamInfo;
    }

    public String getChooseStudent() {
        return chooseStudent;
    }

    public void setChooseStudent(String chooseStudent) {
        this.chooseStudent = chooseStudent;
    }

    public String getAddStudentNumber() {
        return addStudentNumber;
    }

    public void setAddStudentNumber(String addStudentNumber) {
        this.addStudentNumber = addStudentNumber;
    }

    public String getAddStudentName() {
        return addStudentName;
    }

    public void setAddStudentName(String addStudentName) {
        this.addStudentName = addStudentName;
    }

    public TeamManagerImpl getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManagerImpl teamManager) {
        this.teamManager = teamManager;
    }

    public StudentManagerImpl getStudentManager() {
        return studentManager;
    }

    public void setStudentManager(StudentManagerImpl studentManager) {
        this.studentManager = studentManager;
    }

    public UserManagerImpl getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    public String teaminfo() throws Exception {

        Map<String,Object> session = ActionContext.getContext().getSession();

        int teamNumber = Integer.parseInt(selectTeamInfo);

        List<TeamEntity> teamList = teamManager.getTeam(teamNumber);

        TeamEntity team = teamManager.listToTeam(teamList);

        List<StudentEntity> studentList = studentManager.getExistStudent(team);

        session.put("teamSelected", teamNumber);

        session.put("studentList",studentList);

        return SUCCESS;
    }

    public String modifyStudent(){

        String modifyStudentNum[] = new String[7];
        String modifyStudentName[] = new String[7];
        String modifyStudentDeploy[] = new String[7];
        String modifyStudentFrontpage[] = new String[7];
        String modifyStudentFunction[] = new String[7];
        String modifyStudentPerformance[] = new String[7];
        String modifyStudentCode[] = new String[7];
        String modifyStudentDocument[] = new String[7];

        for (int i=1;i<=6;i++){
            HttpServletRequest request= ServletActionContext.getRequest();
            modifyStudentNum[i] = request.getParameter("StudentNumber"+i);



            if (modifyStudentNum[i]==null){
                continue;
            }

            modifyStudentName[i] = request.getParameter("StudentName"+i);
            modifyStudentDeploy[i] = request.getParameter("deployscore"+i);
            modifyStudentFrontpage[i] = request.getParameter("frontpagescore"+i);
            modifyStudentFunction[i] = request.getParameter("functionscore"+i);
            modifyStudentPerformance[i] = request.getParameter("performancescore"+i);
            modifyStudentCode[i] = request.getParameter("codescore"+i);
            modifyStudentDocument[i] = request.getParameter("documentscore"+i);

            if (studentManager.isStudentExist(Integer.parseInt(modifyStudentNum[i])).compareTo("exist")==0){
                StudentEntity student = studentManager.listToStudent(studentManager.getStudent(Integer.parseInt(modifyStudentNum[i])));
                try{
                    int deploy = Integer.parseInt(modifyStudentDeploy[i]);
                    if (0<=deploy&&deploy<=100){
                        student.setDeployscore(deploy);
                    }
                }catch (Exception e){

                }
                try{
                    int frontpage = Integer.parseInt(modifyStudentFrontpage[i]);
                    if (0<=frontpage&&frontpage<=100){
                        student.setFrontpagescore(frontpage);
                    }
                }catch (Exception e){

                }

                try{
                    int function = Integer.parseInt(modifyStudentFunction[i]);
                    if (0<=function&&function<=100){
                        student.setFunctionscore(function);
                    }
                }catch (Exception e){

                }

                try{
                    int performance = Integer.parseInt(modifyStudentPerformance[i]);
                    if (0<=performance&&performance<=100){
                        student.setPerformancescore(performance);
                    }
                }catch (Exception e){

                }

                try{
                    int code = Integer.parseInt(modifyStudentCode[i]);
                    if (0<=code&&code<=100){
                        student.setCodescore(code);
                    }
                }catch (Exception e){

                }

                try{
                    int document = Integer.parseInt(modifyStudentDocument[i]);
                    if (0<=document&&document<=100){
                        student.setDocumentscore(document);
                    }
                }catch (Exception e){

                }
               studentManager.insert(student);
            }


        }
        Map<String,Object> session = ActionContext.getContext().getSession();
        int teamNumber = Integer.parseInt(selectTeamInfo);
        List<TeamEntity> teamList = teamManager.getTeam(teamNumber);
        TeamEntity team = teamManager.listToTeam(teamList);
        List<StudentEntity> studentList = studentManager.getExistStudent(team);
        session.put("studentList",studentList);
        return SUCCESS;
    }

    public String deletestudent(){

        Map<String,Object> session = ActionContext.getContext().getSession();

        int teamNumber = (int)session.get("teamSelected");

        String chosenDeleteStudent = chooseStudent;

        int chosenStudentToDelete = 0;

        if (chosenDeleteStudent!=null){
            chosenStudentToDelete=Integer.parseInt(chosenDeleteStudent);
        }

        if (chosenStudentToDelete==0){

        }
        else{
            //获得学生的学号
            //int studentNum = teamService.digitToNum(teamNumber,chosenStudentToDelete);
            HttpServletRequest request= ServletActionContext.getRequest();
            int studentNum = Integer.parseInt(request.getParameter("StudentNumber"+chosenDeleteStudent));
            //student表删除学生的组号
            studentManager.deleteTeamStudent(studentNum);
            //team表删除memberX的学号
            teamManager.deleteStudent(teamNumber,studentNum);
            //int teamNumber = Integer.parseInt(request.getParameter("selectTeam"));
        }

        List<TeamEntity> teamList = teamManager.getTeam(teamNumber);
        TeamEntity team = teamManager.listToTeam(teamList);
        List<StudentEntity> studentList = studentManager.getExistStudent(team);

        session.put("studentList",studentList);
        return SUCCESS;
    }

    public String addstudent(){

        Map<String,Object> session = ActionContext.getContext().getSession();

        int teamNumber = (int) session.get("teamSelected");
        //int teacherID = (int) request.getSession().getAttribute("userID");
        int addSNumber = Integer.parseInt(addStudentNumber);
        String addSName = addStudentName;

        //Student addNewStudent = new Student(addStudentNumber,addStudentName,teamNumber);
        StudentEntity addNewStudent = new StudentEntity(addSNumber,addSName,-1,teamNumber,-1,-1,-1,-1,-1,-1);

        //检查user表中是否存在新增加的学生的学号
        String isNumberExist = userManager.checkUserExist(addNewStudent);

        //若user表中存在学生
        if (isNumberExist.compareTo("exist")==0){
            //不需要检查student表中是否存在addnewstudent
            //saveOrUpdate若不存在则插入,若存在则更新
            studentManager.insert(addNewStudent);
            teamManager.updateTeamMember(teamNumber,addNewStudent);
            //更新team表成员信息
        }
        else{//若user表中不存在学生,则插入学生信息
            userManager.insertStudent(addNewStudent);
            studentManager.insert(addNewStudent);
            teamManager.updateTeamMember(teamNumber,addNewStudent);
        }

        //team表studentX添加学号
        List<TeamEntity> teamList = teamManager.getTeam(teamNumber);
        TeamEntity team = teamManager.listToTeam(teamList);
        List<StudentEntity> studentList = studentManager.getExistStudent(team);

        session.put("studentList",studentList);
        return SUCCESS;

    }




}
