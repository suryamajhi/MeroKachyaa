package com.project.merokachya.controllers.instructor;

import com.project.merokachya.dto.LessonRequest;
import com.project.merokachya.entities.Chapter;
import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.Lesson;
import com.project.merokachya.repos.ChapterRepository;
import com.project.merokachya.repos.CourseRepository;
import com.project.merokachya.repos.LessonRepository;
import com.project.merokachya.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "instructorLessonController")
@RequestMapping("/instructor")
public class LessonController {

    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    LessonService lessonService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @GetMapping("/lessons")
    public String viewLessons(ModelMap modelMap) {
        List<Lesson> lessons = lessonRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        modelMap.addAttribute("lessons", lessons);
        modelMap.addAttribute("courses", courses);
        return "instructor.lesson.index";
    }

    @PostMapping("/lesson/new")
    public String newLesson(@RequestParam("course_id") int courseId, ModelMap modelMap) {
        Course course = courseRepository.findById(courseId).get();
        List<Chapter> chapters = course.getChaptersById();
        modelMap.addAttribute("chapters", chapters);
        modelMap.addAttribute("courseName", course.getName());
        return "instructor.lesson.new";
    }

    @PostMapping("/lesson/add")
    public String addLesson(@ModelAttribute("lessonRequest") LessonRequest lessonRequest) {
        Lesson lesson = lessonService.addLesson(lessonRequest);
        return "redirect:/instructor/course/edit/" + lesson.getChapterByChapterId().getCourseId();
    }

    @GetMapping("/lesson/chapter/{chapterId}")
    public String addLesson(@PathVariable int chapterId, ModelMap modelMap) {
        Chapter chapter = chapterRepository.findById(chapterId).get();
        modelMap.addAttribute("chapter", chapter);
        modelMap.addAttribute("courseName", chapter.getCourseByCourseId().getName());
        return "instructor.lesson.new";
    }


    @GetMapping("/lesson/edit/{id}")
    public String showEditLesson(@PathVariable int id, ModelMap modelMap) {
        Lesson lesson = lessonRepository.findById(id).get();
        List<Chapter> chapters = lesson.getChapterByChapterId().getCourseByCourseId().getChaptersById();
        modelMap.addAttribute("chapters", chapters);
        modelMap.addAttribute("lesson", lesson);
        return "instructor.lesson.edit";
    }

    @PostMapping("/lesson/edit/{id}")
    public String editLesson(@PathVariable int id, @ModelAttribute("lessonRequest") LessonRequest lessonRequest) {
        Lesson lesson = lessonService.editLesson(id, lessonRequest);
        return "redirect:/instructor/course/" + lesson.getChapterByChapterId().getCourseId();
    }

    @GetMapping("/lesson/delete/{id}")
    public String deleteLesson(@PathVariable int id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonRepository.deleteById(id);
        return "redirect:/instructor/course/edit" + lesson.getChapterByChapterId().getCourseId();
    }

    @GetMapping("/lesson/{id}")
    public String showLesson(@PathVariable int id, ModelMap modelMap) {
        Lesson lesson = lessonRepository.findById(id).get();
        modelMap.addAttribute("title", lesson.getTitle());
        modelMap.addAttribute("lesson", lesson);
        return "instructor.lesson.display";
    }
}
