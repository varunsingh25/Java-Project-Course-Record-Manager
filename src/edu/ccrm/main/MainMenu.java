package edu.ccrm.main;

import edu.ccrm.cli.*;
import edu.ccrm.config.AppConfig;
import edu.ccrm.service.DataArchiver;

import java.util.Scanner;

/**
 * Main entry point for the Campus Course & Records Manager (CCRM) application.
 * This class initializes the system and starts the command-line interface.
 */
public class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the Singleton AppConfig
        AppConfig config = AppConfig.getInstance();
        System.out.println("CCRM Application Initialized.");
        System.out.println("Data directory: " + config.getProperty("data.directory.path"));
        System.out.println("------------------------------------");

        // Demonstration of an anonymous inner class for a simple one-off task
        Runnable welcomeTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Welcome to CCRM - The future of campus management!");
            }
        };
        welcomeTask.run();

        displayPlatformSummary();

        // Start the main application loop
        mainLoop();

        System.out.println("Thank you for using CCRM. Exiting.");
        scanner.close();
    }

    private static void mainLoop() {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        StudentMenu.handleStudentMenu(scanner);
                        break;
                    case 2:
                        CourseMenu.handleCourseMenu(scanner);
                        break;
                    case 3:
                        EnrollmentMenu.handleEnrollmentMenu(scanner);
                        break;
                    case 4:
                        DataUtilityMenu.handleDataUtilityMenu(scanner);
                        break;
                    case 5:
                        ReportsMenu.handleReportsMenu(scanner);
                        break;
                    case 6:
                        // Demonstration of Diamond Problem resolution
                        DataArchiver archiver = new DataArchiver();
                        archiver.log("System shutdown initiated."); // Will call the explicit override
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n--- CCRM Main Menu ---");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Manage Enrollment & Grades");
        System.out.println("4. Data Utilities");
        System.out.println("5. Run Reports");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayPlatformSummary() {
        System.out.println("\n--- Java Platform Summary ---");
        System.out.println("Java SE (Standard Edition): For desktop and server applications. This project is built using Java SE.");
        System.out.println("Java ME (Micro Edition): For resource-constrained devices like mobile phones (legacy) and IoT.");
        System.out.println("Java EE (Enterprise Edition): For large-scale, distributed enterprise applications with web services.");
        System.out.println("----------------------------\n");
    }
}