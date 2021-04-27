package com.project.merokachya.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Entity
public class Blog {

    private int id;
    private String title;
    private String content;
    private byte[] image;
    private Date date;
    private Integer userId;
    private List<Comment> commentsById;
    private User userByUserId;

    private String base64Image;


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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @OneToMany(mappedBy = "blogByBlogId")
    public List<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(List<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image=" + Arrays.toString(image) +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }

    @Transient
    public String getBase64Image() {
        if (this.image != null) return base64Image = Base64.getEncoder().encodeToString(this.image);
        else return null;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
