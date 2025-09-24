package edu.ccrm.cli;

import edu.ccrm.domain.Course;
import edu.ccrm.service.CourseService;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseMenu {
    private static final CourseService courseService = new CourseService();

    public static void handleCourseMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add New Course");
            System.out.println("2. List All Courses (Sorted)");
            System.out.println("3. Search/Filter Courses");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addCourse(scanner);
                        break;
                    case 2:
                        listCourses();
                        break;
                    case 3:
                        searchCourses(scanner);
                        break;
                    case 4:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void addCourse(Scanner scanner) {
        try {
            System.out.print("Enter Course Code (e.g., CS101): ");
            String code = scanner.nextLine();
            System.out.print("Enter Course Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Credits: ");
            int credits = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            // Using the Builder pattern to create a Course object
            Course course = new Course.CourseBuilder(code, title)
                .credits(credits)
                .department(department)
                .build();
            courseService.addCourse(course);
            System.out.println("Course added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    private static void listCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        // Demonstration of Arrays utility class for sorting
        String[] courseCodes = courses.stream().map(c -> c.getCode().getCode()).toArray(String[]::new);
        Arrays.sort(courseCodes);
        System.out.println("\n--- All Course Codes (Sorted) ---");
        for (String code : courseCodes) {
            System.out.println(code);
        }
    }
    
    private static void searchCourses(Scanner scanner) {
        System.out.print("Enter search keyword (or department, semester): ");
        String keyword = scanner.nextLine();
        List<Course> results = courseService.searchCourses(keyword); // Uses Stream API
        System.out.println("\n--- Search Results ---");
        if (results.isEmpty()) {
            System.out.println("No matching courses found.");
        } else {
            results.forEach(System.out::println);
        }
    }
}