package edu.ccrm.cli;

import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;
import edu.ccrm.service.StudentService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReportsMenu {
    private static final StudentService studentService = new StudentService();

    public static void handleReportsMenu(Scanner scanner) {
        System.out.println("\n--- Reports ---");
        System.out.println("1. GPA Distribution Report");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            generateGpaDistributionReport();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void generateGpaDistributionReport() {
        System.out.println("\n--- GPA Distribution Report ---");
        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No student data available to generate a report.");
            return;
        }

        // Demonstration of a Stream pipeline to aggregate data for a report
        Map<String, Long> gpaDistribution = students.stream()
            .filter(s -> s.calculateGpa() > 0)
            .collect(Collectors.groupingBy(
                student -> {
                    double gpa = student.calculateGpa();
                    if (gpa >= 9.0) return "Excellent (9.0+)";
                    if (gpa >= 8.0) return "Good (8.0-8.9)";
                    if (gpa >= 7.0) return "Average (7.0-7.9)";
                    return "Needs Improvement (<7.0)";
                },
                Collectors.counting()
            ));

        gpaDistribution.forEach((range, count) ->
            System.out.printf("GPA Range: %-25s | Student Count: %d%n", range, count)
        );
    }
}