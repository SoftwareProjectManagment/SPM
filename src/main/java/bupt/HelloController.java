package main.java.bupt;

import com.sun.org.apache.xpath.internal.operations.Bool;
import main.java.bupt.domain.Student;
import main.java.bupt.domain.Teacher;
import main.java.bupt.domain.Team;
import main.java.bupt.service.StudentService;
import main.java.bupt.service.TeacherService;
import main.java.bupt.service.TeamService;
import main.java.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martin on 2015/12/23.
 */
@Controller
//@RequestMapping("/")
public class HelloController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/student.mvc",method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student","command", new Student());
    }

    @RequestMapping(value = "/addStudent.mvc", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringMVC_war_exploded")Student student, ModelMap model) {
        model.addAttribute("id", student.getId());
        model.addAttribute("name", student.getName());
        model.addAttribute("score", student.getScore());
        model.addAttribute("lesson",student.getGroupnum());
        studentService.insert(student);
        return "result";
    }

    @RequestMapping(value = "/studentpanel.mvc", method = RequestMethod.GET)
    public ModelAndView display(HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("userName", name);
        return new ModelAndView("student/studentpanel",model);
    }

    @RequestMapping(value = "/deploy.mvc", method = RequestMethod.POST)
    public ModelAndView delpoy(HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);
        List<Team> teamList = teamService.getTeam(20);

        final Map<String, Object> model = new LinkedHashMap<String, Object>();

        String filename = teamList.get(0).getFilename();
        String IPaddress = teamList.get(0).getIpaddress();

        int checkFunction = teamList.get(0).getFunctiontest();
        int checkFrontPage = teamList.get(0).getFrontpagetest();
        int checkPerformance = teamList.get(0).getPerformancetest();
        int checkCodeOne = teamList.get(0).getCodetestone();
        int checkCodeTwo = teamList.get(0).getCodetestwo();
        int checkDocument = teamList.get(0).getDocumentest();

        model.put("resultList", list);
        model.put("deployedFile",filename);
        model.put("deployedIP",IPaddress);
        model.put("checkFunction",checkFunction);
        model.put("checkFrontPage",checkFrontPage);
        model.put("checkDocument",checkDocument);
        model.put("checkCodeOne",checkCodeOne);
        model.put("checkCodeTwo",checkCodeTwo);
        model.put("checkPerformance",checkPerformance);

        return new ModelAndView("student/deploy",model);
    }

    @RequestMapping(value = "/upload.mvc", method = RequestMethod.POST)
    public ModelAndView upload( HttpServletRequest request){
        String filename = request.getParameter("filename");
        String IPaddress = request.getParameter("IPaddress");
        String name = (String) request.getSession().getAttribute("username");

        List<Student> list=studentService.getStudent(name);
        List<Team> teamList = teamService.getTeam(20);

        Team team = teamService.listToTeam(teamList);

        team.setFilename(filename);
        team.setIpaddress(IPaddress);

        teamService.update(team);
        //do deploy


        List<Team> teamListAgain = teamService.getTeam(20);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();

        String isDeployed=teamListAgain.get(0).getFilename();
        int checkFrontPage = teamListAgain.get(0).getFrontpagetest();
        filename = teamListAgain.get(0).getFilename();
        IPaddress = teamListAgain.get(0).getIpaddress();
        int checkFunction = teamListAgain.get(0).getFunctiontest();
        int checkPerformance = teamListAgain.get(0).getPerformancetest();
        int checkCodeOne = teamListAgain.get(0).getCodetestone();
        int checkCodeTwo = teamListAgain.get(0).getCodetestwo();
        int checkDocument = teamListAgain.get(0).getDocumentest();

        model.put("checkDocument",checkDocument);
        model.put("checkCodeOne",checkCodeOne);
        model.put("checkCodeTwo",checkCodeTwo);
        model.put("checkPerformance",checkPerformance);
        model.put("checkFunction",checkFunction);
        model.put("isDeployed",isDeployed);
        model.put("resultList",list);
        model.put("deployedFile",filename);
        model.put("deployedIP",IPaddress);

        model.put("checkFrontPage",checkFrontPage);

        return new ModelAndView("student/deploy",model);
    }

    @RequestMapping(value = "/frontpage.mvc", method = RequestMethod.POST)
    public ModelAndView frontpage( HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);

        List<Team> teamList = teamService.getTeam(20);

        Team team = teamService.listToTeam(teamList);

        //do frontpage examination

        team.setFrontpagetest(-2);

        teamService.update(team);

        List<Team> teamListAgain = teamService.getTeam(20);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();


        String isDeployed=teamListAgain.get(0).getFilename();
        int checkFrontPage = teamListAgain.get(0).getFrontpagetest();
        String filename = teamListAgain.get(0).getFilename();
        String IPaddress = teamListAgain.get(0).getIpaddress();
        int checkFunction = teamListAgain.get(0).getFunctiontest();
        int checkPerformance = teamListAgain.get(0).getPerformancetest();
        int checkCodeOne = teamListAgain.get(0).getCodetestone();
        int checkCodeTwo = teamListAgain.get(0).getCodetestwo();
        int checkDocument = teamListAgain.get(0).getDocumentest();

        model.put("checkDocument",checkDocument);
        model.put("checkCodeOne",checkCodeOne);
        model.put("checkCodeTwo",checkCodeTwo);
        model.put("checkPerformance",checkPerformance);
        model.put("checkFunction",checkFunction);
        model.put("deployedFile",filename);
        model.put("deployedIP",IPaddress);
        model.put("isDeployed",isDeployed);
        model.put("resultList",list);
        model.put("checkFrontPage",checkFrontPage);

        return new ModelAndView("student/deploy",model);
    }

    @RequestMapping(value = "/function.mvc", method = RequestMethod.POST)
    public ModelAndView function( HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);

        List<Team> teamList = teamService.getTeam(20);

        Team team = teamService.listToTeam(teamList);

        //do function examination

        team.setFunctiontest(-2);

        teamService.update(team);

        List<Team> teamListAgain = teamService.getTeam(20);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();


        String isDeployed=teamListAgain.get(0).getFilename();
        int checkFrontPage = teamListAgain.get(0).getFrontpagetest();
        String filename = teamListAgain.get(0).getFilename();
        String IPaddress = teamListAgain.get(0).getIpaddress();
        int checkFunction = teamListAgain.get(0).getFunctiontest();
        int checkPerformance = teamListAgain.get(0).getPerformancetest();
        int checkCodeOne = teamListAgain.get(0).getCodetestone();
        int checkCodeTwo = teamListAgain.get(0).getCodetestwo();
        int checkDocument = teamListAgain.get(0).getDocumentest();

        model.put("checkDocument",checkDocument);
        model.put("checkCodeOne",checkCodeOne);
        model.put("checkCodeTwo",checkCodeTwo);
        model.put("checkPerformance",checkPerformance);
        model.put("checkFunction",checkFunction);
        model.put("deployedFile",filename);
        model.put("deployedIP",IPaddress);
        model.put("isDeployed",isDeployed);
        model.put("resultList",list);
        model.put("checkFrontPage",checkFrontPage);

        return new ModelAndView("student/deploy",model);
    }

    @RequestMapping(value = "/performance.mvc", method = RequestMethod.POST)
    public ModelAndView performance( HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);

        List<Team> teamList = teamService.getTeam(20);

        Team team = teamService.listToTeam(teamList);

        //do performance examination

        team.setPerformancetest(-2);

        teamService.update(team);

        List<Team> teamListAgain = teamService.getTeam(20);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();


        String isDeployed=teamListAgain.get(0).getFilename();
        int checkFrontPage = teamListAgain.get(0).getFrontpagetest();
        String filename = teamListAgain.get(0).getFilename();
        String IPaddress = teamListAgain.get(0).getIpaddress();
        int checkFunction = teamListAgain.get(0).getFunctiontest();
        int checkPerformance = teamListAgain.get(0).getPerformancetest();
        int checkCodeOne = teamListAgain.get(0).getCodetestone();
        int checkCodeTwo = teamListAgain.get(0).getCodetestwo();
        int checkDocument = teamListAgain.get(0).getDocumentest();

        model.put("checkDocument",checkDocument);
        model.put("checkCodeOne",checkCodeOne);
        model.put("checkCodeTwo",checkCodeTwo);
        model.put("checkPerformance",checkPerformance);
        model.put("checkFunction",checkFunction);
        model.put("deployedFile",filename);
        model.put("deployedIP",IPaddress);
        model.put("isDeployed",isDeployed);
        model.put("resultList",list);
        model.put("checkFrontPage",checkFrontPage);

        return new ModelAndView("student/deploy",model);

    }

    @RequestMapping(value = "/code.mvc", method = RequestMethod.POST)
    public ModelAndView code( HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);

        List<Team> teamList = teamService.getTeam(20);

        Team team = teamService.listToTeam(teamList);

        //do performance examination

        team.setCodetestone(-2);
        team.setCodetestwo(-2);

        teamService.update(team);

        List<Team> teamListAgain = teamService.getTeam(20);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();


        String isDeployed=teamListAgain.get(0).getFilename();
        int checkFrontPage = teamListAgain.get(0).getFrontpagetest();
        String filename = teamListAgain.get(0).getFilename();
        String IPaddress = teamListAgain.get(0).getIpaddress();
        int checkFunction = teamListAgain.get(0).getFunctiontest();
        int checkPerformance = teamListAgain.get(0).getPerformancetest();
        int checkCodeOne = teamListAgain.get(0).getCodetestone();
        int checkCodeTwo = teamListAgain.get(0).getCodetestwo();
        int checkDocument = teamListAgain.get(0).getDocumentest();

        model.put("checkDocument",checkDocument);
        model.put("checkCodeOne",checkCodeOne);
        model.put("checkCodeTwo",checkCodeTwo);
        model.put("checkPerformance",checkPerformance);
        model.put("checkFunction",checkFunction);
        model.put("deployedFile",filename);
        model.put("deployedIP",IPaddress);
        model.put("isDeployed",isDeployed);
        model.put("resultList",list);
        model.put("checkFrontPage",checkFrontPage);

        return new ModelAndView("student/deploy",model);

    }

    @RequestMapping(value = "/document.mvc", method = RequestMethod.POST)
    public ModelAndView document( HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);

        List<Team> teamList = teamService.getTeam(20);

        Team team = teamService.listToTeam(teamList);

        //do performance examination

        team.setDocumentest(-2);

        teamService.update(team);

        List<Team> teamListAgain = teamService.getTeam(20);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();


        String isDeployed=teamListAgain.get(0).getFilename();
        int checkFrontPage = teamListAgain.get(0).getFrontpagetest();
        String filename = teamListAgain.get(0).getFilename();
        String IPaddress = teamListAgain.get(0).getIpaddress();
        int checkFunction = teamListAgain.get(0).getFunctiontest();
        int checkPerformance = teamListAgain.get(0).getPerformancetest();
        int checkCodeOne = teamListAgain.get(0).getCodetestone();
        int checkCodeTwo = teamListAgain.get(0).getCodetestwo();
        int checkDocument = teamListAgain.get(0).getDocumentest();

        model.put("checkDocument",checkDocument);
        model.put("checkCodeOne",checkCodeOne);
        model.put("checkCodeTwo",checkCodeTwo);
        model.put("checkPerformance",checkPerformance);
        model.put("checkFunction",checkFunction);
        model.put("deployedFile",filename);
        model.put("deployedIP",IPaddress);
        model.put("isDeployed",isDeployed);
        model.put("resultList",list);
        model.put("checkFrontPage",checkFrontPage);

        return new ModelAndView("student/deploy",model);

    }

    @RequestMapping(value = "/score.mvc", method = RequestMethod.GET)
    public ModelAndView score(HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);
        if (list.get(0).getScore()<0){
            list.clear();
        }
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("userName", name);
        return new ModelAndView("student/score",model);
    }

    @RequestMapping(value = "/teacherpanel.mvc", method = RequestMethod.GET)
    public ModelAndView teacherpanel(HttpServletRequest request){
        int teacherID = 0;
        try {
            teacherID = (int) request.getSession().getAttribute("userID");
        }catch (Exception e){
            return new ModelAndView("teacher/fail");
        }
        //List<Student> list=studentService.getStudent(name);
        List<Team> teamList = null;
        for (int i=1;i<=22;i++){
            List<Team> tempTeamList = teamService.getTeam(i);
            if (!tempTeamList.isEmpty()){
                Team tempTeam = teamService.listToTeam(tempTeamList);
                if (teamList == null){
                    teamList = tempTeamList;
                }
                else{
                    teamList.add(tempTeam);
                }
            }
        }
        if (teamList == null){
            teamList = teamService.getTeam(0);
        }
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("teacherID", teacherID);
        model.put("teamList",teamList);
        return new ModelAndView("teacher/teacherpanel",model);
    }

    @RequestMapping(value = "/enroll.mvc", method = RequestMethod.POST)
    public ModelAndView enroll(HttpServletRequest request){
        int teacherID = 0;
        try {
            teacherID = (int) request.getSession().getAttribute("userID");
        }catch (Exception e){
            return new ModelAndView("teacher/fail");
        }
        //List<Student> list=studentService.getStudent(name);
        ArrayList<Integer> noRegisterList = new ArrayList<>();
        for (int i=1;i<=22;i++){
            List<Team> tempTeamList = teamService.getTeam(i);
            if (tempTeamList.isEmpty()){
                noRegisterList.add(i);
            }
        }
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("noRegisterList",noRegisterList);
        model.put("teacherID", teacherID);
        return new ModelAndView("teacher/enroll",model);
    }

    @RequestMapping(value = "/enrollFinish.mvc", method = RequestMethod.POST)
    public ModelAndView enrollFinish(HttpServletRequest request){
        int studentOne,studentTwo,studentThree,studentFour,studentFive,studentSix;

        try {
            studentOne = Integer.parseInt(request.getParameter("numberOne"));
        }catch (Exception e){
            studentOne=-1;
        }
        try {
            studentTwo = Integer.parseInt(request.getParameter("numberTwo"));
        }catch (Exception e){
            studentTwo=-1;
        }
        try {
            studentThree = Integer.parseInt(request.getParameter("numberThree"));
        }catch (Exception e){
            studentThree=-1;
        }
        try {
            studentFour = Integer.parseInt(request.getParameter("numberFour"));
        }catch (Exception e){
            studentFour=-1;
        }
        try {
            studentFive = Integer.parseInt(request.getParameter("numberFive"));
        }catch (Exception e){
            studentFive=-1;
        }
        try {
            studentSix = Integer.parseInt(request.getParameter("numberSix"));
        }catch (Exception e){
            studentSix=-1;
        }

        int teamNumber;
        try {
            teamNumber = Integer.parseInt(request.getParameter("teamNumber"));
        }catch (Exception e){
            teamNumber=-1;
            return new ModelAndView("teacher/teacherpanel");
        }

        if (teamNumber<1 || teamNumber>22){
            return new ModelAndView("teacher/teacherpanel");
        }

        Team team = new Team(teamNumber,-1,-1,-1,-1,-1,-1,-1,"in:valid","in:valid",studentOne,studentTwo,studentThree,studentFour,studentFive,studentSix);
        teamService.insert(team);

        int teacherID = 0;
        try {
            teacherID = (int) request.getSession().getAttribute("userID");
        }catch (Exception e){
            return new ModelAndView("teacher/fail");
        }
        //List<Student> list=studentService.getStudent(name);
        ArrayList<Integer> noRegisterList = new ArrayList<>();
        for (int i=1;i<=22;i++){
            List<Team> tempTeamList = teamService.getTeam(i);
            if (tempTeamList.isEmpty()){
                noRegisterList.add(i);
            }
        }
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("noRegisterList",noRegisterList);
        model.put("teacherID", teacherID);
        return new ModelAndView("teacher/enroll",model);
    }

    @RequestMapping(value = "/parameter.mvc", method = RequestMethod.POST)
    public ModelAndView parameter(HttpServletRequest request){
        int teacherID = (int) request.getSession().getAttribute("userID");
        //List<Student> list=studentService.getStudent(name);
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("teacherID", teacherID);
        return new ModelAndView("teacher/parameter",model);
    }

    @RequestMapping(value = "/teaminfo.mvc", method = RequestMethod.POST)
    public ModelAndView teaminfo(HttpServletRequest request){
        int teamNumber = Integer.parseInt(request.getParameter("selectTeamInfo"));
        String teamNum = (String) request.getSession().getAttribute("teamNo");
        if (teamNum!=null){
            request.getSession().removeAttribute("teamNo");
        }
        else {
            request.getSession().setAttribute("teamNo",teamNumber);
        }
        int teacherID = (int) request.getSession().getAttribute("userID");
        List<Team> teamList = teamService.getTeam(teamNumber);

        Team team = teamService.listToTeam(teamList);

        List<Student> studentList = studentService.getExistStudent(team);

        //List<Student> list=studentService.getStudent(name);
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("teamSelected", teamNumber);
        model.put("resultList", list);
        model.put("teacherID", teacherID);
        model.put("teamList",teamList);
        model.put("studentList",studentList);
        return new ModelAndView("teacher/teamInfo",model);
    }

    @RequestMapping(value = "/addStudentInfo.mvc", method = RequestMethod.POST)
    public ModelAndView addStudentInfo(HttpServletRequest request){
        int teamNumber = Integer.parseInt(request.getParameter("selectTeam"));
        int teacherID = (int) request.getSession().getAttribute("userID");
        int addStudentNumber = Integer.parseInt(request.getParameter("addStudentNumber"));
        String addStudentName = request.getParameter("addStudentName");

        //Student addNewStudent = new Student(addStudentNumber,addStudentName,teamNumber);
        Student addNewStudent = new Student(addStudentNumber,addStudentName,-1,teamNumber,-1,-1,-1,-1,-1,-1);

        //检查user表中是否存在新增加的学生的学号
        String isNumberExist = userService.checkUserExist(addNewStudent);

        //若user表中存在学生
        if (isNumberExist.compareTo("exist")==0){
            //不需要检查student表中是否存在addnewstudent
            //saveOrUpdate若不存在则插入,若存在则更新
            studentService.insert(addNewStudent);
            teamService.updateTeamMember(teamNumber,addNewStudent);
            //更新team表成员信息
        }
        else{//若user表中不存在学生,则插入学生信息
            userService.insertStudent(addNewStudent);
            studentService.insert(addNewStudent);
            teamService.updateTeamMember(teamNumber,addNewStudent);
        }

        //team表studentX添加学号

        List<Team> teamList = teamService.getTeam(teamNumber);

        Team team = teamService.listToTeam(teamList);

        List<Student> studentList = studentService.getExistStudent(team);

        //List<Student> list=studentService.getStudent(name);
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("teamSelected", teamNumber);
        model.put("resultList", list);
        model.put("teacherID", teacherID);
        model.put("teamList",teamList);
        model.put("studentList",studentList);
        return new ModelAndView("teacher/teamInfo",model);
    }

    @RequestMapping(value = "/deleteStudentInfo.mvc", method = RequestMethod.POST)
    public ModelAndView deleteStudentInfo(HttpServletRequest request){
        int teamNumber = (int) request.getSession().getAttribute("teamNo");
        String chosenDeleteStudent[] = new String[7];
        int chosenStudentToDelete = 0;
        for (int i=1;i<=6;i++){
            chosenDeleteStudent[i] = request.getParameter("chooseStudent"+i);
            if (chosenDeleteStudent[i]!=null){
                chosenStudentToDelete=Integer.parseInt(chosenDeleteStudent[i]);
                break;
            }
        }

        if (chosenStudentToDelete==0){

        }
        else{
            //获得学生的学号
            int studentNum = teamService.digitToNum(teamNumber,chosenStudentToDelete);
            //student表删除学生的组号
            studentService.deleteTeamStudent(studentNum);
            //team表删除memberX的学号
            teamService.deleteStudent(teamNumber,studentNum);
        //int teamNumber = Integer.parseInt(request.getParameter("selectTeam"));
        }
        int teacherID = (int) request.getSession().getAttribute("userID");
        List<Team> teamList = teamService.getTeam(teamNumber);
        Team team = teamService.listToTeam(teamList);
        List<Student> studentList = studentService.getExistStudent(team);
        //List<Student> list=studentService.getStudent(name);
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("teamSelected", teamNumber);
        model.put("resultList", list);
        model.put("teacherID", teacherID);
        model.put("teamList",teamList);
        model.put("studentList",studentList);
        return new ModelAndView("teacher/teamInfo",model);
    }

    @RequestMapping(value = "/modifyStudentInfo.mvc", method = RequestMethod.POST)
    public ModelAndView modifyStudentInfo(HttpServletRequest request){
        int teamNumber = (int) request.getSession().getAttribute("teamNo");
        String modifyStudentNum[] = new String[7];
        String modifyStudentName[] = new String[7];
        String modifyStudentDeploy[] = new String[7];
        String modifyStudentFrontpage[] = new String[7];
        String modifyStudentFunction[] = new String[7];
        String modifyStudentPerformance[] = new String[7];
        String modifyStudentCode[] = new String[7];
        String modifyStudentDocument[] = new String[7];

        for (int i=1;i<=6;i++){
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

            if (studentService.isStudentExist(Integer.parseInt(modifyStudentNum[i])).compareTo("exist")==0){
                Student student = studentService.listToStudent(studentService.getStudent(Integer.parseInt(modifyStudentNum[i])));
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
                studentService.insert(student);
            }


        }

        int teacherID = (int) request.getSession().getAttribute("userID");
        List<Team> teamList = teamService.getTeam(teamNumber);
        Team team = teamService.listToTeam(teamList);
        List<Student> studentList = studentService.getExistStudent(team);
        //List<Student> list=studentService.getStudent(name);
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("teamSelected", teamNumber);
        model.put("resultList", list);
        model.put("teacherID", teacherID);
        model.put("teamList",teamList);
        model.put("studentList",studentList);
        return new ModelAndView("teacher/teamInfo",model);
    }

}
