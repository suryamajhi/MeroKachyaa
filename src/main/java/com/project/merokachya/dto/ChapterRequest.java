package com.project.merokachya.dto;

public class ChapterRequest {

    private String title;
    private Integer serial;
    private Integer courseId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Integer getCourseId(){return courseId;}
    public void setCourseId(Integer courseId){this.courseId = courseId;}
}
