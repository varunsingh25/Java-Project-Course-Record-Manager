package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.StudentService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class DataExporter {

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();

    public static void exportAllData() throws IOException {
        Path exportDir = Path.of(AppConfig.getInstance().getProperty("export.directory.path"));
        Files.createDirectories(exportDir);
        exportStudents(exportDir);
        exportCourses(exportDir);
        System.out.println("Data exported successfully to " + exportDir);
    }

    private static void exportStudents(Path dir) throws IOException {
        List<String> lines = studentService.getAllStudents().stream()
                .map(s -> String.join(",",
                        String.valueOf(s.getPersonId()),
                        s.getFullName(),
                        s.getEmail(),
                        s.getRegistrationNumber()))
                .collect(Collectors.toList());
        lines.add(0, "id,fullName,email,regNo"); // Header
        Files.write(dir.resolve("students_export.csv"), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static void exportCourses(Path dir) throws IOException {
        List<String> lines = courseService.getAllCourses().stream()
                .map(c -> String.join(",",
                        c.getCode().getCode(),
                        c.getTitle(),
                        String.valueOf(c.getCredits()),
                        c.getDepartment()))
                .collect(Collectors.toList());
        lines.add(0, "code,title,credits,department"); // Header
        Files.write(dir.resolve("courses_export.csv"), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}