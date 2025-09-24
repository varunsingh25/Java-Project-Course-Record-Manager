package edu.ccrm.domain;

import java.time.LocalDate;

public class Enrollment {
    private final Student student;
    private final Course course;
    private final LocalDate enrollmentDate;
    private Grade grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
}