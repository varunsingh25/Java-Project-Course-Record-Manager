package edu.ccrm.cli;

import edu.ccrm.io.BackupService;
import edu.ccrm.io.DataExporter;
import edu.ccrm.io.DataImporter;
import edu.ccrm.util.RecursiveFileUtils;

import java.nio.file.Path;
import java.util.Scanner;

public class DataUtilityMenu {

    public static void handleDataUtilityMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Data Utilities ---");
            System.out.println("1. Import Data from Files");
            System.out.println("2. Export Data to Files");
            System.out.println("3. Create Backup");
            System.out.println("4. Show Backup Directory Size (Recursive)");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        DataImporter.importAllData();
                        break;
                    case 2:
                        DataExporter.exportAllData();
                        break;
                    case 3:
                        Path backupPath = BackupService.performBackup();
                        System.out.println("Backup created successfully at: " + backupPath);
                        break;
                    case 4:
                        long size = RecursiveFileUtils.calculateDirectorySize(BackupService.getBackupRoot());
                        System.out.printf("Total size of backup directory: %d bytes (%.2f KB)%n", size, size / 1024.0);
                        break;
                    case 5:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.err.println("Operation failed: " + e.getMessage());
            }
        }
    }
}