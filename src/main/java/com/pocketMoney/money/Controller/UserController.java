package com.pocketMoney.money.Controller;

import com.pocketMoney.money.model.Student;
import com.pocketMoney.money.model.user;
import com.pocketMoney.money.reporiste.UserRepository;
import com.pocketMoney.money.service.Impl.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userservice;
    @Autowired
    private UserRepository repo;

    @GetMapping("/users")
    public String ListeUsers(Model model) {
        List<user> users = userservice.findAllusers();
        model.addAttribute("users", users);
        return "user-liste";

    }
    @GetMapping("/home")
    public String getPage(Model model) {
        return "HomePage";

    }
    @GetMapping("/newStudent")
    public String createUserForm(Model model) {
        user user = new user();
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/newStudent")
    public String saveTheUser(user user){
        userservice.save(user);
        return"redirect:/login";
    }

//    @GetMapping("/displayUser")
//    public String displayUser(Model model) {
//        user user = userservice.findUserById();
//        model.addAttribute("user",user);
//        return "StudentInfo";
//    }

    @PostMapping("/user/new")
    public String saveUser(@ModelAttribute("user") user user) {
        userservice.save(user);
        return "redirect:/users";
    }
    @GetMapping("users/{userId}/edit")
    public String editUserForm(@PathVariable("userId") int userId,Model model) {
        user user = userservice.findUserById(userId);
        model.addAttribute("user",user);
        return "EditPage";

    }
    @GetMapping(value = "/signup")
 public  String getRegistration(Model model)
 {Student student=new Student();
     model.addAttribute("student",student);
     return "StudentLogin";
 }
    @GetMapping("/")
    public String getRegisterPage(Model model) {
        return "HomePage";
    }

    @GetMapping("users/{userId}/delete")
    public String deleteUserForm(@PathVariable("userId") int userId,Model model) {
        repo.deleteById(userId);
        return "redirect:/users";

    }
    @PostMapping(value = "/depositlist/{userId}")
public String getUserDeposit(@PathVariable int userId,Model model)
{
user us=repo.findById(userId);
model.addAttribute("userDetail",us);
model.addAttribute("userDeposit",repo.getAllUserDeposit(us));
return "user-deposit";
}
}