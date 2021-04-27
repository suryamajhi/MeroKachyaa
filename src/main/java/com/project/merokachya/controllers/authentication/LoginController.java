package com.project.merokachya.controllers.authentication;

import com.project.merokachya.repos.UserRepository;
import com.project.merokachya.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityService securityService;

    @GetMapping("/login")
    public String showLogin() {
        return "authentication.login";
    }

    @GetMapping("/403")
    public String accessDeny() {
        return "authentication.noaccess";
    }
}
