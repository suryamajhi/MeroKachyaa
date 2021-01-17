package com.project.merokachya.controllers.admin;

import com.project.merokachya.dto.ProfileRequest;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.CourseRepository;
import com.project.merokachya.repos.UserRepository;
import com.project.merokachya.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller(value = "adminProfileController")
@RequestMapping("/admin")
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable int id, ModelMap modelMap){
        User user = userRepository.findById(id).get();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("title", user.getName());
        return "admin.profile.index";
    }
    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable int id, @ModelAttribute("profileRequest") ProfileRequest profileRequest){
        profileService.editProfile(id, profileRequest);
        return "redirect:/admin/profile/"+id;
    }
}
