package com.pocketMoney.money.Controller;

import com.pocketMoney.money.model.Student;
import com.pocketMoney.money.model.user;
import com.pocketMoney.money.reporiste.StudentRepository;
import com.pocketMoney.money.reporiste.UserRepository;
import com.pocketMoney.money.service.Impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/login")
    public String getLoginPage(Model model) {
        Student student = new Student();
        model.addAttribute("student",new Student() );
        return "LoginPage";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute Student student, Model model) {
        System.out.println("login request :" + student.getEmail());
        Student authenticated = studentService.authenticate(student.getEmail(), student.getPassword());
        System.out.println(authenticated);
        if (authenticated != null) {
            if(authenticated.getRole().equals("ADMIN")){
            model.addAttribute("studentLogin", authenticated.getLogin());
            return "redirect:/users";}
            else{
                model.addAttribute("studentLogin", authenticated.getLogin());
                return "redirect:/newStudent";}
        }
        else {
            return "error_Page";
        }
    }
@Autowired
//    UserRepository userRepo;
    StudentRepository studentRepository;
    @PostMapping("/")
    public String register(Student user) {
        studentRepository.save(user);
        return "redirect:/login";
    }

}
