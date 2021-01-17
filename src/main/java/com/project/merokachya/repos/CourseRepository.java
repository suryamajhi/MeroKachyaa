package com.project.merokachya.repos;

import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByName(String name);

    List<Course> findByCategoryId(int id);
}
