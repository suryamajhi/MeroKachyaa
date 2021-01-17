package com.project.merokachya.controllers.admin;

import com.project.merokachya.entities.User;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("adminUserController")
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/all")
    public String allUsers(ModelMap modelMap){
        List<User> users = userRepository.findAll();
        modelMap.addAttribute("users", users);
        return "admin.users.all";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return "redirect:/admin/users/all";
    }
}
