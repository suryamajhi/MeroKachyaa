package com.project.merokachya.controllers.admin;

import com.project.merokachya.dto.CategoryRequest;
import com.project.merokachya.entities.Category;
import com.project.merokachya.repos.CategoryRepository;
import com.project.merokachya.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "adminCategoryController")
@RequestMapping("/admin")
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
        return "admin.category.index";
    }

    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute("categoryRequest") CategoryRequest category){
        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }
    @GetMapping("/category/edit/{id}")
    public String showEditCategory(@PathVariable int id,ModelMap modelMap){
        Category category = categoryRepository.findById(id).get();
        modelMap.addAttribute("category", category);
        modelMap.addAttribute("title","Edit Category");
        return "admin.category.edit";
    }

    @PostMapping("/category/edit/{id}")
    public String editCategory(@PathVariable int id, @ModelAttribute("categoryRequest") CategoryRequest category){
        categoryService.editCategory(id, category);
        return "redirect:/admin/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryRepository.deleteById(id);
        return "redirect:/admin/category";
    }
}
