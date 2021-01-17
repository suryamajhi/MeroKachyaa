package com.project.merokachya.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Discussion {

    private int id;
    private String content;
    private Date date;
    private Integer lessonId;
    private Integer userId;

    private Lesson lessonByLessonId;
    private User userByUserId;
    private List<DiscussionReply> discussionReplyById;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "lesson_id")
    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", insertable = false,updatable = false)
    public Lesson getLessonByLessonId() {
        return lessonByLessonId;
    }

    public void setLessonByLessonId(Lesson lessonByLessonId) {
        this.lessonByLessonId = lessonByLessonId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", insertable = false,updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "discussionByDiscussionId")
    public List<DiscussionReply> getDiscussionReplyById() {
        return discussionReplyById;
    }

    public void setDiscussionReplyById(List<DiscussionReply> discussionReplyById) {
        this.discussionReplyById = discussionReplyById;
    }
}
