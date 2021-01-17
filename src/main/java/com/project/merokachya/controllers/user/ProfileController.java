package com.project.merokachya.controllers.user;

import com.project.merokachya.dto.ProfileRequest;
import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.CourseRepository;
import com.project.merokachya.repos.UserRepository;
import com.project.merokachya.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller(value = "userProfileController")
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileService profileService;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id, ModelMap modelMap){
        modelMap.addAttribute("user",userRepository.findById(id).get());
        return "home.profile";
    }
    @GetMapping("/profile")
    public String profile(ModelMap modelMap){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());
        
        modelMap.addAttribute("user",user);
        return "home.profile";
    }
    @PostMapping("/profile/edit")
    public String editUser(@ModelAttribute("profileRequest") ProfileRequest profileRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());
        profileService.editProfile(user.getId(), profileRequest);
        return "redirect:/profile";
    }
}
