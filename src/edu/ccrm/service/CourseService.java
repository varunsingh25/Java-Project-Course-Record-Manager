package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.CourseCode;
import edu.ccrm.util.Comparators;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseService {
    private static final Map<CourseCode, Course> courses = new HashMap<>();

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }
    
    public void addAllCourses(List<Course> courseList) {
        for (Course c : courseList) {
            addCourse(c);
        }
    }

    public Course findCourseByCode(String code) {
        return courses.get(new CourseCode(code));
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    /**
     * Searches courses using the Stream API and a Predicate.
     * Demonstrates: Streams, Lambdas, Functional Interfaces.
     */
    public List<Course> searchCourses(String keyword) {
        String lowerKeyword = keyword.toLowerCase();

        // A predicate to filter courses based on title, code, or department
        Predicate<Course> filter = course ->
            course.getTitle().toLowerCase().contains(lowerKeyword) ||
            course.getCode().getCode().toLowerCase().contains(lowerKeyword) ||
            course.getDepartment().toLowerCase().contains(lowerKeyword);

        return courses.values().stream()
                .filter(filter)
                .sorted(Comparators.COURSE_BY_CODE) // Using a Comparator lambda from a utility class
                .collect(Collectors.toList());
    }
}