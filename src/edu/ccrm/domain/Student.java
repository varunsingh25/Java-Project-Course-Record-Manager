package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a student, extending the Person class.
 * Demonstrates: Inheritance, Polymorphism (overrides).
 */
public class Student extends Person {
    private static int regCounter = 1001;
    private String registrationNumber;
    private StudentStatus status;
    private LocalDate enrollmentDate;
    private final List<Enrollment> enrolledCourses;

    public Student(int personId, String fullName, String email, LocalDate enrollmentDate) {
        super(personId, fullName, email);
        this.registrationNumber = "REG" + regCounter++;
        this.status = StudentStatus.ACTIVE;
        this.enrollmentDate = enrollmentDate;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollInCourse(Enrollment enrollment) {
        this.enrolledCourses.add(enrollment);
    }

    public double calculateGpa() {
        double totalPoints = 0;
        int totalCredits = 0;
        
        for(Enrollment e : enrolledCourses){
            if(e.getGrade() != null){
                totalPoints += e.getGrade().getGradePoint() * e.getCourse().getCredits();
                totalCredits += e.getCourse().getCredits();
            }
        }
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    @Override
    public String getProfile() {
        return String.format("Student Profile: %s (%s) - GPA: %.2f", getFullName(), registrationNumber, calculateGpa());
    }

    @Override
    public String toString() {
        return String.format("Student [ID=%d, RegNo=%s, Name=%s, Status=%s]", getPersonId(), registrationNumber, getFullName(), status);
    }
    
    // Getters
    public String getRegistrationNumber() { return registrationNumber; }
    public List<Enrollment> getEnrolledCourses() { return enrolledCourses; }
    public int getTotalCredits() {
        return enrolledCourses.stream().mapToInt(e -> e.getCourse().getCredits()).sum();
    }
}

enum StudentStatus {
    ACTIVE, INACTIVE, GRADUATED
}