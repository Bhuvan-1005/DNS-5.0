package com.exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private int studentId;
    private String studentName;
    private Course course;

    public Student() {
        this.studentId = 1;
        this.studentName = "John Doe";
    }

    @Autowired
    public void setCourse(Course course) {
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{studentId=" + studentId + ", studentName='" + studentName + "', course=" + course + "}";
    }
}
