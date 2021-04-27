package com.project.merokachya.controllers.instructor;

import com.project.merokachya.entities.Review;
import com.project.merokachya.repos.CourseRepository;
import com.project.merokachya.repos.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller(value = "instructorReviewController")
@RequestMapping("/instructor")
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CourseRepository courseRepository;


    @GetMapping("/course/{id}/review")
    public String showReview(@PathVariable int id, ModelMap modelMap) {
        List<Review> reviews = reviewRepository.findAllByCourseId(id);
        modelMap.addAttribute("reviews", reviews);
        modelMap.addAttribute("title", "Reviews");
        modelMap.addAttribute("course", courseRepository.findById(id).get());
        return "instructor.review.index";
    }

    @GetMapping("/course/{courseId}/review/delete/{id}")
    public String delete(@PathVariable int id, @PathVariable int courseId) {
        reviewRepository.deleteById(id);
        return "redirect:/instructor/course/" + courseId + "/review";
    }
}
