package com.project.merokachya.controllers.instructor;

import com.project.merokachya.dto.CategoryRequest;
import com.project.merokachya.entities.Category;
import com.project.merokachya.repos.CategoryRepository;
import com.project.merokachya.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "instructorCategoryController")
@RequestMapping("/instructor")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public String showCategory(ModelMap modelMap){
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("title","Category");
        modelMap.addAttribute("categories", categories);
        return "instructor.category.index";
    }
}
