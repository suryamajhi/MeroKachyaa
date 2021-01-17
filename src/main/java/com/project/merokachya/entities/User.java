package com.project.merokachya.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Entity
public class User {


    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String school;
    private byte[] image;
    private String signature;

    private List<Role> roles;
    private List<Blog> blogsById;
    private List<Comment> commentsById;
    private List<CommentReply> commentReplyById;
    private List<Discussion> discussionsById;
    private List<DiscussionReply> discussionReplyById;
    private List<Review> reviewsById;

    private List<Course> courses;
    
    private String base64Image;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<Blog> getBlogsById() {return blogsById;}

    public void setBlogsById(List<Blog> blogsById) {
        this.blogsById = blogsById;
    }
    @OneToMany(mappedBy = "userByUserId")
    public List<Comment> getCommentsById() {return commentsById;}

    public void setCommentsById(List<Comment> commentsById){
        this.commentsById = commentsById;
    }
    @OneToMany(mappedBy = "userByUserId")
    public List<CommentReply> getCommentReplyById(){ return commentReplyById;}

    public void setCommentReplyById(List<CommentReply> commentReplyById){
        this.commentReplyById = commentReplyById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<Discussion> getDiscussionsById() {
        return discussionsById;
    }

    public void setDiscussionsById(List<Discussion> discussionsById) {
        this.discussionsById = discussionsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<DiscussionReply> getDiscussionReplyById() {
        return discussionReplyById;
    }

    public void setDiscussionReplyById(List<DiscussionReply> discussionReplyById) {
        this.discussionReplyById = discussionReplyById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<Review> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(List<Review> reviewsById) {
        this.reviewsById = reviewsById;
    }

    @Transient
    public String getBase64Image() {
        if(this.image!=null) return base64Image = Base64.getEncoder().encodeToString(this.image);
        else return null;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @ManyToMany
    @JoinTable(name = "user_course", joinColumns = @JoinColumn(name ="user_id" ),inverseJoinColumns = @JoinColumn(name = "course_id"))
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", school='" + school + '\'' +
                ", image=" + Arrays.toString(image) +
                ", signature='" + signature + '\'' +
                '}';
    }
}
