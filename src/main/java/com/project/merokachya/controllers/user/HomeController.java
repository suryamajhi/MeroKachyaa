package com.project.merokachya.controllers.user;

import com.project.merokachya.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "userHomeController")
public class HomeController {

    @Autowired
    CourseRepository courseRepository;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("courses", courseRepository.findAll());
        modelMap.addAttribute("title", "Home");
        return "home.index";
    }

    @GetMapping("/about")
    public String about() {
        return "home.about";
    }

}
