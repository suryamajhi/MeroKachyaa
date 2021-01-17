package com.project.merokachya.repos;

import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByCourseId(Integer courseId);
}
