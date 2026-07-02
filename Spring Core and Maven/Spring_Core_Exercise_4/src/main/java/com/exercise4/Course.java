package com.exercise4;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private String courseName;
    private int courseId;

    public Course() {
        this.courseName = "Spring Framework";
        this.courseId = 101;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Course{courseId=" + courseId + ", courseName='" + courseName + "'}";
    }
}
