package com.project.merokachya.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Comment {

    private int id;
    private String content;
    private Integer userId;
    private Integer blogId;
    private Date date;

    private Blog blogByBlogId;
    private User userByUserId;
    private List<CommentReply> commentReplyById;


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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Column(name = "blog_id")
    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Blog getBlogByBlogId(){ return blogByBlogId;}

    public void setBlogByBlogId(Blog blogByBlogId) { this.blogByBlogId = blogByBlogId; }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUserByUserId() { return userByUserId;}

    public void setUserByUserId(User userByUserId){ this.userByUserId = userByUserId;}

    @OneToMany(mappedBy = "commentByCommentId")
    public List<CommentReply> getCommentReplyById(){ return commentReplyById;}

    public void setCommentReplyById(List<CommentReply> commentReplyById){
        this.commentReplyById = commentReplyById;
    }
}
