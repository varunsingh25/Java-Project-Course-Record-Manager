package edu.ccrm.cli;

import edu.ccrm.domain.Student;
import edu.ccrm.service.StudentService;
import edu.ccrm.service.TranscriptService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private static final StudentService studentService = new StudentService();
    private static final TranscriptService transcriptService = new TranscriptService();

    public static void handleStudentMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add New Student");
            System.out.println("2. List All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Print Student Transcript");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        listStudents();
                        break;
                    case 3:
                        updateStudent(scanner);
                        break;
                    case 4:
                        printTranscript(scanner);
                        break;
                    case 5:
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

    private static void addStudent(Scanner scanner) {
        try {
            System.out.print("Enter Full Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            Student student = new Student(0, name, email, LocalDate.now());
            studentService.addStudent(student);
            System.out.println("Student added successfully with ID: " + student.getPersonId());
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private static void listStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- List of Students ---");
        for (Student s : students) {
            System.out.println(s); // Polymorphic call to toString()
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentService.findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        // Demonstration of a labeled jump statement
        searchLoop: // label
        while (true) {
            System.out.println("Current student details: " + student);
            System.out.print("What to update? (name/email/done): ");
            String field = scanner.nextLine();
            switch (field.toLowerCase()) {
                case "name":
                    System.out.print("Enter new name: ");
                    student.setFullName(scanner.nextLine());
                    continue searchLoop; // Jumps to the beginning of the while loop
                case "email":
                    System.out.print("Enter new email: ");
                    student.setEmail(scanner.nextLine());
                    break; // Breaks the switch, continues loop
                case "done":
                    break searchLoop; // Breaks out of the labeled loop
                default:
                    System.out.println("Invalid field.");
            }
        }
        System.out.println("Student details updated.");
    }

    private static void printTranscript(Scanner scanner) {
        System.out.print("Enter Student ID for transcript: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentService.findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        String transcript = transcriptService.generateTranscript(student);
        System.out.println(transcript);
    }
}