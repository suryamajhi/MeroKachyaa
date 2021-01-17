package com.project.merokachya.controllers.user;

import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.User;
import com.project.merokachya.entities.UserCourse;
import com.project.merokachya.repos.*;
import com.project.merokachya.services.ReviewService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller(value = "userCourseController")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCourseRepository userCourseRepository;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/courses")
    public String showCourses(ModelMap modelMap){
        modelMap.addAttribute("courses",courseRepository.findAll());
        modelMap.addAttribute("categories",categoryRepository.findAll());
        modelMap.addAttribute("blogs", blogRepository.findAll());
        return "home.courses";
    }

    @GetMapping("/course/{id}")
    public String showCourse(@PathVariable int id, ModelMap modelMap){
        modelMap.addAttribute("reviewAverage",reviewService.calculateAverage(id));
        modelMap.addAttribute("course",courseRepository.findById(id).get());
        modelMap.addAttribute("categories",categoryRepository.findAll());
        modelMap.addAttribute("blogs", blogRepository.findAll());
        return "home.course";
    }

    @GetMapping("/course/{id}/detail")
    public String showDetail(@PathVariable int id, ModelMap modelMap){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);

        if(userCourseRepository.findByUserIdAndCourseId(user.getId(),id)==null) {
            UserCourse userCourse = new UserCourse();
            userCourse.setCourseId(id);
            userCourse.setUserId(user.getId());
            userCourseRepository.save(userCourse);
        }

        modelMap.addAttribute("course", courseRepository.findById(id).get());
        modelMap.addAttribute("chapters", chapterRepository.findChaptersByCourseId(id));
        return "home.course.detail";
    }
}
