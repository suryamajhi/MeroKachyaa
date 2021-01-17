package com.project.merokachya.controllers.admin;

import com.project.merokachya.dto.LessonRequest;
import com.project.merokachya.entities.Chapter;
import com.project.merokachya.entities.Course;
import com.project.merokachya.entities.Lesson;
import com.project.merokachya.repos.*;
import com.project.merokachya.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "adminLessonController")
@RequestMapping("/admin")
public class LessonController {

    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    LessonService lessonService;

    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    DiscussionReplyRepository discussionReplyRepository;

    @GetMapping("/lessons")
    public String viewLessons(ModelMap modelMap){
        List<Lesson> lessons = lessonRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        modelMap.addAttribute("lessons", lessons);
        modelMap.addAttribute("courses", courses);
        return "admin.lesson.index";
    }

    @PostMapping("/lesson/new")
    public String newLesson(@RequestParam("course_id") int courseId,ModelMap modelMap){
        Course course = courseRepository.findById(courseId).get();
        List<Chapter> chapters = course.getChaptersById();
        modelMap.addAttribute("chapters",chapters);
        modelMap.addAttribute("courseName", course.getName());
        return "admin.lesson.new";
    }
    @PostMapping("/lesson/add")
    public String addLesson(@ModelAttribute("lessonRequest") LessonRequest lessonRequest){
        Lesson lesson = lessonService.addLesson(lessonRequest);
        return "redirect:/admin/course/edit/"+lesson.getChapterByChapterId().getCourseId();
    }
    @GetMapping("/lesson/chapter/{chapterId}")
    public String addLesson(@PathVariable int chapterId, ModelMap modelMap){
        Chapter chapter = chapterRepository.findById(chapterId).get();
        modelMap.addAttribute("chapter",chapter);
        modelMap.addAttribute("courseName",chapter.getCourseByCourseId().getName());
        return "admin.lesson.new";
    }
    


    @GetMapping("/lesson/edit/{id}")
    public String showEditLesson(@PathVariable int id, ModelMap modelMap){
        Lesson lesson = lessonRepository.findById(id).get();
        List<Chapter> chapters = lesson.getChapterByChapterId().getCourseByCourseId().getChaptersById();
        modelMap.addAttribute("lesson",lesson);
        modelMap.addAttribute("chapter", lesson.getChapterByChapterId());
        return "admin.lesson.edit";
    }
    @PostMapping("/lesson/edit")
    public String editLesson(@RequestParam int id, @ModelAttribute("lessonRequest") LessonRequest lessonRequest){
        Lesson lesson = lessonService.editLesson(id, lessonRequest);
        return "redirect:/admin/course/edit/"+lesson.getChapterByChapterId().getCourseId();
    }



    @GetMapping("/lesson/delete/{id}")
    public String deleteLesson(@PathVariable int id){
        Lesson lesson = lessonRepository.findById(id).get();
        int courseId = lesson.getChapterByChapterId().getCourseId();
        lessonRepository.deleteById(id);
        return "redirect:/admin/course/edit/"+ courseId;
    }


    @GetMapping("/lesson/{id}")
    public String showLesson(@PathVariable int id, ModelMap modelMap){
        Lesson lesson = lessonRepository.findById(id).get();
        modelMap.addAttribute("title",lesson.getTitle());
        modelMap.addAttribute("lesson", lesson);
        return "admin.lesson.display";
    }

    //For discussion and reply
    @GetMapping("/discussion/{id}/delete")
    public String deleteDiscussion(@PathVariable int id){
        int lessonId = discussionRepository.findById(id).get().getLessonId();
        discussionRepository.deleteById(id);
        return "redirect:/admin/lesson/"+lessonId;
    }
    @GetMapping("/discussionReply/{id}/delete")
    public String deleteReply(@PathVariable int id){
        int lessonId = discussionReplyRepository.findById(id).get().getDiscussionByDiscussionId().getLessonId();
        discussionReplyRepository.deleteById(id);
        return "redirect:/admin/lesson/"+lessonId;
    }

}
