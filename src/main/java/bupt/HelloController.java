package main.java.bupt;

import main.java.bupt.domain.Student;
import main.java.bupt.domain.Team;
import main.java.bupt.service.StudentService;
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
        return new ModelAndView("studentpanel",model);
    }

    @RequestMapping(value = "/deploy.mvc", method = RequestMethod.POST)
    public ModelAndView delpoy(HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("userName", name);
        return new ModelAndView("deploy",model);
    }

    @RequestMapping(value = "/score.mvc", method = RequestMethod.POST)
    public ModelAndView score(HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        model.put("userName", name);
        return new ModelAndView("score",model);
    }

    @RequestMapping(value = "/upload.mvc", method = RequestMethod.POST)
    public ModelAndView upload(@ModelAttribute()Team team,ModelMap modelMap, HttpServletRequest request){
        String filename = request.getParameter("filename");
        String IPaddress = request.getParameter("IPaddress");
        String name = (String) request.getSession().getAttribute("username");

        List<Student> list=studentService.getStudent(name);

        List<Team> teamList = teamService.getTeam(20);

        team.setTeamnumber(teamList.get(0).getTeamnumber());
        team.setDeploytest(teamList.get(0).getDeploytest());
        team.setFrontpagetest(teamList.get(0).getFrontpagetest());
        team.setFunctiontest(teamList.get(0).getPerformancetest());
        team.setCodetestone(teamList.get(0).getCodetestone());
        team.setCodetestwo(teamList.get(0).getCodetestwo());
        team.setDocumentest(teamList.get(0).getDocumentest());
        team.setFilename(filename);
        team.setIpaddress(IPaddress);

//        modelMap.addAttribute("teamnumber",teamList.get(0).getTeamnumber());
//        modelMap.addAttribute("deploytest",teamList.get(0).getDeploytest());
//        modelMap.addAttribute("frontpagetest",teamList.get(0).getFrontpagetest());
//        modelMap.addAttribute("performancetest",teamList.get(0).getPerformancetest());
//        modelMap.addAttribute("codetestone",teamList.get(0).getCodetestone());
//        modelMap.addAttribute("codetestwo",teamList.get(0).getCodetestwo());
//        modelMap.addAttribute("documentest",teamList.get(0).getDocumentest());
//        modelMap.addAttribute("filename",filename);
//        modelMap.addAttribute("ipaddress",IPaddress);
        teamService.update(team);
        //do deploy


        List<Team> teamListAgain = teamService.getTeam(20);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();

        String isDeployed="success";

        model.put("isDeployed",isDeployed);
        model.put("resultList", teamListAgain);

        return new ModelAndView("deploy",model);
    }

}
