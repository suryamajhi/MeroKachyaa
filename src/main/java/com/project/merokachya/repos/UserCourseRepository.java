package com.project.merokachya.repos;

import com.project.merokachya.entities.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Integer> {
    void deleteByUserIdAndCourseId(Integer userId, Integer courseId);

    UserCourse findByUserIdAndCourseId(Integer userId, Integer courseId);
}
