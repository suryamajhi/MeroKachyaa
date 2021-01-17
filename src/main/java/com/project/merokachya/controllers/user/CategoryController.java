package com.project.merokachya.controllers.user;


import com.project.merokachya.repos.BlogRepository;
import com.project.merokachya.repos.CategoryRepository;
import com.project.merokachya.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller(value = "userCategoryController")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/category")
    public String category(ModelMap modelMap){
        modelMap.addAttribute("categories",categoryRepository.findAll());
        modelMap.addAttribute("blogs",blogRepository.findAll());
        return "home.category";
    }
    @GetMapping("/category/{id}")
    public String courses(@PathVariable int id, ModelMap modelMap){
        modelMap.addAttribute("category",categoryRepository.findById(id).get());
        modelMap.addAttribute("blogs", blogRepository.findAll());
        modelMap.addAttribute("categories",categoryRepository.findAll());
        return "home.category.course";
    }
}
