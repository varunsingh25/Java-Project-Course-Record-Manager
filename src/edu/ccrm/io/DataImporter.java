package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.StudentService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataImporter {

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();

    public static void importAllData() throws IOException {
        importStudents();
        importCourses();
    }

    public static void importStudents() throws IOException {
        Path path = Path.of(AppConfig.getInstance().getProperty("data.directory.path"), "students.csv");
        if (!Files.exists(path)) {
            System.out.println("students.csv not found. Skipping import.");
            return;
        }

        try (Stream<String> lines = Files.lines(path)) {
            List<Student> students = lines.skip(1) // Skip header
                .map(line -> {
                    // Demonstration of String.split()
                    String[] fields = line.split(",");
                    return new Student(Integer.parseInt(fields[0]), fields[1], fields[2], LocalDate.parse(fields[3]));
                })
                .collect(Collectors.toList());
            studentService.addAllStudents(students);
            System.out.println("Successfully imported " + students.size() + " students.");
        }
    }

    public static void importCourses() throws IOException {
        Path path = Path.of(AppConfig.getInstance().getProperty("data.directory.path"), "courses.csv");
        if (!Files.exists(path)) {
            System.out.println("courses.csv not found. Skipping import.");
            return;
        }

        try (Stream<String> lines = Files.lines(path)) {
            List<Course> courses = lines.skip(1)
                .map(line -> {
                    String[] fields = line.split(",");
                    return new Course.CourseBuilder(fields[0], fields[1])
                        .credits(Integer.parseInt(fields[2]))
                        .department(fields[3])
                        .build();
                })
                .collect(Collectors.toList());
            courseService.addAllCourses(courses);
            System.out.println("Successfully imported " + courses.size() + " courses.");
        }
    }
}