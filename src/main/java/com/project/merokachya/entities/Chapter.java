package com.project.merokachya.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chapter {

    private int id;
    private String title;
    private int serial;
    private Integer courseId;

    private Course courseByCourseId;
    private List<Lesson> lessonsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @OneToMany(mappedBy = "chapterByChapterId")
    public List<Lesson> getLessonsById() {
        return lessonsById;
    }

    public void setLessonsById(List<Lesson> lessons) {
        this.lessonsById = lessons;
    }

    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id",insertable = false, updatable = false)
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", order=" + serial +
                ", courseId=" + courseId +
                '}';
    }
}
