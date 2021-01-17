package com.project.merokachya.dto;

import org.springframework.web.multipart.MultipartFile;

public class CourseRequest {

    private String name;

    private Integer categoryId;
    private MultipartFile image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CourseRequest{" +
                "name='" + name + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", image=" + image +
                '}';
    }
}
