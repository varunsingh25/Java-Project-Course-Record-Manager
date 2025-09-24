package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;
import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.MaxCreditLimitExceededException;

public class EnrollmentService {
    private static final int MAX_CREDITS_PER_SEMESTER = 18;
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();

    public void enrollStudent(int studentId, String courseCode)
            throws MaxCreditLimitExceededException, DuplicateEnrollmentException {

        Student student = studentService.findStudentById(studentId);
        Course course = courseService.findCourseByCode(courseCode);

        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course not found.");
        }

        // Business Rule 1: Check for duplicate enrollment
        boolean alreadyEnrolled = student.getEnrolledCourses().stream()
                .anyMatch(e -> e.getCourse().equals(course));
        if (alreadyEnrolled) {
            throw new DuplicateEnrollmentException("Student already enrolled in course " + courseCode);
        }

        // Business Rule 2: Check max credit limit
        if (student.getTotalCredits() + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            throw new MaxCreditLimitExceededException("Enrollment exceeds max credit limit of " + MAX_CREDITS_PER_SEMESTER);
        }

        Enrollment enrollment = new Enrollment(student, course);
        student.enrollInCourse(enrollment);
    }

    public void assignGrade(int studentId, String courseCode, String gradeStr) {
        Student student = studentService.findStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }

        Grade grade = Grade.valueOf(gradeStr); // Throws IllegalArgumentException if invalid

        student.getEnrolledCourses().stream()
            .filter(e -> e.getCourse().getCode().getCode().equals(courseCode.toUpperCase()))
            .findFirst()
            .ifPresentOrElse(
                enrollment -> enrollment.setGrade(grade),
                () -> { throw new IllegalArgumentException("Student is not enrolled in this course."); }
            );
    }
}