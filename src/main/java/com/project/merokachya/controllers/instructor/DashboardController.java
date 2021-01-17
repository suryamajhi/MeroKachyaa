package com.project.merokachya.controllers.instructor;

import com.project.merokachya.repos.CategoryRepository;
import com.project.merokachya.repos.CourseRepository;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "instructorDashboardController")
@RequestMapping("instructor")
public class DashboardController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("title","Dashboard");
        modelMap.addAttribute("categoryCount", categoryRepository.count());
        modelMap.addAttribute("courseCount", courseRepository.count());
        modelMap.addAttribute("userCount",userRepository.count());
        return "instructor.dashboard.index";
    }
}
