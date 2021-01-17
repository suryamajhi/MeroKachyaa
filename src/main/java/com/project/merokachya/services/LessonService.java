package com.project.merokachya.services;

import com.project.merokachya.dto.LessonRequest;
import com.project.merokachya.entities.Lesson;

public interface LessonService {
    Lesson addLesson(LessonRequest lessonRequest);
    Lesson editLesson(int id,LessonRequest lessonRequest);
}
