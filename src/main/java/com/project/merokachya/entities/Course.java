package com.project.merokachya.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

@Entity
public class Course {

    private int id;
    private String name;
    private byte[] image;
    private Date date;
    private Integer userId;
    private Integer categoryId;

    private Category categoryByCategoryId;
    private User userByUserId;

    private List<User> students;

    private List<Chapter> chaptersById;
    private List<Review> reviewsById;

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

    @Column(name = "category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",insertable = false,updatable = false)
    public User getUserByUserId() { return userByUserId; }

    public void setUserByUserId(User userByUserId){
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false,updatable = false)
    public Category getCategoryByCategoryId(){return categoryByCategoryId;}

    public void setCategoryByCategoryId(Category categoryByCategoryId){
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public List<Review> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(List<Review> reviewsById) {
        this.reviewsById = reviewsById;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public List<Chapter> getChaptersById() {
        return chaptersById;
    }

    public void setChaptersById(List<Chapter> chaptersById) {
        this.chaptersById = chaptersById;
    }

    @Transient
    public String getBase64Image() {
        if(this.image!=null) return Base64.getEncoder().encodeToString(this.image);
        return null;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @ManyToMany
    @JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }
}
