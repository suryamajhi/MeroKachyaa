package com.project.merokachya.controllers.authentication;

import com.project.merokachya.entities.User;
import com.project.merokachya.entities.UserRole;
import com.project.merokachya.repos.UserRepository;
import com.project.merokachya.repos.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;


    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/register")
    public String showRegister(){
        return "authentication.register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user){

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        int userId = userRepository.findByEmail(user.getEmail()).getId();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(3);
        userRoleRepository.save(userRole);
        return "redirect:/login";
    }
}
