package com.project.merokachya.controllers.admin;

import com.project.merokachya.dto.CourseRequest;
import com.project.merokachya.entities.Chapter;
import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.*;
import com.project.merokachya.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "adminCourseController")
@RequestMapping("/admin")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    UserCourseRepository userCourseRepository;

    @Autowired
    CourseService courseService;
    
    @GetMapping("/courses")
    public String courses(ModelMap modelMap){
        List<Course> courses = courseRepository.findAll();
        System.out.println();
        modelMap.addAttribute("title","All Courses");
        modelMap.addAttribute("courses", courses);
        
        return "admin.course.index";
    }
    @GetMapping("/course/new")
    public String showAddCourse(ModelMap modelMap){
        modelMap.addAttribute("title","Add New Course");
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "admin.course.new";
    }
    @PostMapping("/course/new")
    public String addCourse(@ModelAttribute("courseRequest") CourseRequest courseRequest){

        Course course = courseService.addCourse(courseRequest);

        return "redirect:/admin/course/edit/"+course.getId();
    }

    @GetMapping("/course/edit/{id}")
    public String showEditcourse(@PathVariable int id,ModelMap modelMap){
        Course course = courseRepository.findById(id).get();
        modelMap.addAttribute("course",course);
        modelMap.addAttribute("categories", categoryRepository.findAll());
        modelMap.addAttribute("chapters", chapterRepository.findChaptersByCourseId(id));
        modelMap.addAttribute("title","Edit Course");
        return "admin.course.edit";
    }

    @PostMapping("/course/edit/{id}")
    public String editCourse(@PathVariable int id, @ModelAttribute("courseRequest") CourseRequest courseRequest){
        Course course =courseService.editCourse(id, courseRequest);
        return "redirect:/admin/course/edit/"+course.getId();
    }


    @GetMapping("/course/delete/{id}")
    public String delete(@PathVariable("id") int id){
        courseRepository.deleteById(id);
        return "redirect:/admin/courses";
    }



    @GetMapping("/course/{courseId}/enrolls")
    public String showEnrolls(@PathVariable int courseId, ModelMap modelMap){
        Course course = courseRepository.findById(courseId).get();
        modelMap.addAttribute("course",course );
        return "admin.course.enroll";
    }
    @Transactional
    @GetMapping("/course/{courseId}/unenroll/{id}")
    public String unEnroll(@PathVariable int id, @PathVariable int courseId){
        userCourseRepository.deleteByUserIdAndCourseId(id,courseId);
        return "redirect:/admin/course/"+courseId+"/enrolls";
    }

}

