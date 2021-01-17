package com.project.merokachya.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class DiscussionReply {

    private int id;
    private String content;
    private Date date;
    private Integer discussionId;
    private Integer userId;

    private Discussion discussionByDiscussionId;
    private User userByUserId;

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

    @Column(name = "discussion_id")
    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "discussion_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Discussion getDiscussionByDiscussionId() {
        return discussionByDiscussionId;
    }

    public void setDiscussionByDiscussionId(Discussion discussionByDiscussionId) {
        this.discussionByDiscussionId = discussionByDiscussionId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
