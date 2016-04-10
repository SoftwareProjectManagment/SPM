package main.java.bupt;

import main.java.bupt.domain.Student;
import main.java.bupt.service.StudentService;
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

    @RequestMapping(value = "/student.mvc",method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student","command", new Student());
    }

    @RequestMapping(value = "/addStudent.mvc", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringMVC_war_exploded")Student student, ModelMap model) {
        model.addAttribute("id", student.getId());
        model.addAttribute("name", student.getName());
        model.addAttribute("score", student.getScore());
        model.addAttribute("lesson",student.getLesson());
        studentService.insert(student);
        return "result";
    }

    @RequestMapping(value = "/display.mvc", method = RequestMethod.GET)
    public ModelAndView display(HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("username");
        List<Student> list=studentService.getStudent(name);
        final Map<String, Object> model = new LinkedHashMap<String, Object>();
        model.put("resultList", list);
        return new ModelAndView("display",model);
    }

}
