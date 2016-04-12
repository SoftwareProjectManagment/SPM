package main.java.bupt;

import main.java.bupt.domain.Student;
import main.java.bupt.domain.Teacher;
import main.java.bupt.domain.Team;
import main.java.bupt.service.StudentService;
import main.java.bupt.service.TeacherService;
import main.java.bupt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/student.mvc",method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student","command", new Student());
    }

    @RequestMapping(value = "/addStudent.mvc", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringMVC_war_exploded")Student student, ModelMap model) {
        model.addAttribute("id", student.getId());
        model.addAttribute("name", student.getName());
        model.addAttribute("score", student.getScore());
        model.addAttribute("lesson",student.getGroup());
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
        return new ModelAndView("score",model);
    }

    @RequestMapping(value = "/teacherpanel.mvc", method = RequestMethod.GET)
    public ModelAndView teacherpanel(HttpServletRequest request){
        int teacherID = (int) request.getSession().getAttribute("userID");
        //List<Student> list=studentService.getStudent(name);
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("teacherID", teacherID);
        return new ModelAndView("teacher/teacherpanel",model);
    }

    @RequestMapping(value = "/enroll.mvc", method = RequestMethod.POST)
    public ModelAndView enroll(HttpServletRequest request){
        int teacherID = (int) request.getSession().getAttribute("userID");
        //List<Student> list=studentService.getStudent(name);
        List<Teacher> list = teacherService.getTeacher(teacherID);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
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


}
