package com.project.merokachya.services;

import com.project.merokachya.dto.ChapterRequest;
import com.project.merokachya.entities.Chapter;
import com.project.merokachya.repos.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{

    @Autowired
    ChapterRepository chapterRepository;

    @Override
    public void addChapter(ChapterRequest chapterRequest) {
        Chapter chapter = new Chapter();
        chapter.setTitle(chapterRequest.getTitle());
        chapter.setSerial(chapterRequest.getSerial());
        chapter.setCourseId(chapterRequest.getCourseId());
        System.out.println(chapter);
        chapterRepository.save(chapter);
    }
}
