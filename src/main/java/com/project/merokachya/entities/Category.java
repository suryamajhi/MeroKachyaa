package com.project.merokachya.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Entity
public class Category {

    private int id;
    private String name;
    private byte[] image;
    private String base64Image;

    private List<Course> coursesById;

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

    @Transient
    public String getBase64Image() {
        if (this.image != null) return base64Image = Base64.getEncoder().encodeToString(this.image);
        else return null;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public List<Course> getCourseById() {
        return coursesById;
    }

    public void setCourseById(List<Course> courseById) {
        this.coursesById = courseById;
    }
}
