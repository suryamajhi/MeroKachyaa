package com.project.merokachya.services;

import com.project.merokachya.dto.LessonRequest;
import com.project.merokachya.entities.Lesson;
import com.project.merokachya.repos.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService{

    @Autowired
    LessonRepository lessonRepository;

    @Override
    public Lesson addLesson(LessonRequest lessonRequest) {
        Lesson lesson = new Lesson();
        lesson.setTitle(lessonRequest.getTitle());
        lesson.setSerial(lessonRequest.getSerial());
        lesson.setContent(lessonRequest.getContent());
        lesson.setChapterId(lessonRequest.getChapterId());

        lessonRepository.save(lesson);

        return lessonRepository.findByTitle(lesson.getTitle());
    }

    @Override
    public Lesson editLesson(int id,LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(id).get();
        lesson.setTitle(lessonRequest.getTitle());
        lesson.setContent(lessonRequest.getContent());
        lesson.setSerial(lessonRequest.getSerial());
        lesson.setChapterId(lessonRequest.getChapterId());
        return lessonRepository.save(lesson);
    }
}
