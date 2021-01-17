package com.project.merokachya.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson {

    private int id;
    private String title;
    private String content;
    private int serial;
    private Integer chapterId;

    private Chapter chapterByChapterId;
    private List<Discussion> discussions;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Column(name = "chapter_id")
    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    @ManyToOne
    @JoinColumn(name = "chapter_id", referencedColumnName = "id",insertable = false, updatable = false)
    public Chapter getChapterByChapterId() {
        return chapterByChapterId;
    }

    public void setChapterByChapterId(Chapter chapterByChapterId) {
        this.chapterByChapterId = chapterByChapterId;
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public List<Discussion> getDiscussions() {
        return discussions;
    }

    public void setDiscussions(List<Discussion> discussions) {
        this.discussions = discussions;
    }
}
