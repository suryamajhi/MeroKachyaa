package com.project.merokachya.controllers.user;

import com.project.merokachya.entities.Review;
import com.project.merokachya.entities.User;
import com.project.merokachya.repos.ReviewRepository;
import com.project.merokachya.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "userReviewController")
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/course/{courseId}/review")
    public String addReview(@PathVariable int courseId, @RequestParam("content") String content, @RequestParam("star") int star) {
        Review review = new Review();
        review.setContent(content);
        review.setStar(star);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        review.setUserId(user.getId());
        review.setCourseId(courseId);

        reviewRepository.save(review);
        return "redirect:/course/" + courseId;

    }

}
