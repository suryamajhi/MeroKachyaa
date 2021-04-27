package com.project.merokachya.controllers.instructor;

import com.project.merokachya.dto.ChapterRequest;
import com.project.merokachya.repos.ChapterRepository;
import com.project.merokachya.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "instructorChapterController")
@RequestMapping("/instructor")
public class ChapterController {

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    ChapterService chapterService;

    @PostMapping("/chapter/add")
    public String addChapter(ChapterRequest chapterRequest) {
        chapterService.addChapter(chapterRequest);
        return "redirect:/instructor/course/edit/" + chapterRequest.getCourseId();
    }

    @GetMapping("/chapter/delete/{id}")
    public String delete(@PathVariable int id) {
        Integer courseId = chapterRepository.findById(id).get().getCourseId();
        chapterRepository.deleteById(id);
        return "redirect:/instructor/course/edit/" + courseId;
    }
}
