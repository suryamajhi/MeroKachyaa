package com.project.merokachya.controllers.user;

import com.project.merokachya.entities.Blog;
import com.project.merokachya.repos.BlogRepository;
import com.project.merokachya.repos.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller(value = "userBlogController")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/blogs")
    public String showBlogs(ModelMap modelMap) {
        modelMap.addAttribute("blogs", blogRepository.findAll());
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "home.blogs";
    }

    @GetMapping("/blog/{id}")
    public String singleBlog(@PathVariable int id, ModelMap modelMap) {
        Blog blog = blogRepository.findById(id).get();
        modelMap.addAttribute("blog", blog);
        modelMap.addAttribute("categories", categoryRepository.findAll());
        modelMap.addAttribute("title", "Blog: " + blog.getTitle());
        modelMap.addAttribute("blogs", blogRepository.findAll());
        return "home.blog-post";
    }
}
