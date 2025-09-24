package edu.ccrm.cli;

import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.MaxCreditLimitExceededException;
import edu.ccrm.service.EnrollmentService;
import java.util.Scanner;

public class EnrollmentMenu {
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void handleEnrollmentMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Enrollment & Grades ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. Record Grade for Student");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        enrollStudent(scanner);
                        break;
                    case 2:
                        recordGrade(scanner);
                        break;
                    case 3:
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

    private static void enrollStudent(Scanner scanner) {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Course Code: ");
            String courseCode = scanner.nextLine();
            enrollmentService.enrollStudent(studentId, courseCode);
            System.out.println("Enrollment successful!");
        } catch (MaxCreditLimitExceededException | DuplicateEnrollmentException e) {
            // Demonstration of multi-catch block
            System.err.println("Enrollment failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid ID or Code: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void recordGrade(Scanner scanner) {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Course Code: ");
            String courseCode = scanner.nextLine();
            System.out.print("Enter Grade (S, A, B, C, D, E, F): ");
            String gradeStr = scanner.nextLine().toUpperCase();
            enrollmentService.assignGrade(studentId, courseCode, gradeStr);
            System.out.println("Grade recorded successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error recording grade: " + e.getMessage());
        }
    }
}