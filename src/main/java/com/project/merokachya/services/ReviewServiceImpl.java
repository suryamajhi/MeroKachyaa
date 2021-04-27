package com.project.merokachya.services;

import com.project.merokachya.entities.Review;
import com.project.merokachya.repos.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public Double calculateAverage(int courseId) {
        List<Review> reviews = reviewRepository.findAllByCourseId(courseId);
        int average = 0;
        int count = 0;
        for (Review review :
                reviews) {
            int star = review.getStar();
            average += star;
            count++;
        }
        return (double) average / count;
    }
}
