package com.project.merokachya.services;

import com.project.merokachya.dto.CourseRequest;
import com.project.merokachya.entities.Course;

public interface CourseService {
    Course addCourse(CourseRequest courseRequest);

    Course editCourse(int id, CourseRequest courseRequest);
}
