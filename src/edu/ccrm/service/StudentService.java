package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static final Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getPersonId(), student);
    }
    
    public void addAllStudents(List<Student> studentList) {
        for (Student s : studentList) {
            addStudent(s);
        }
    }

    public Student findStudentById(int id) {
        return students.get(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    /**
     * Demonstrates a non-static inner class.
     * This class has access to the instance members of the outer class.
     * Here it's used as a helper for a specific formatting task.
     */
    private class ProfilePrinter {
        public void printDetailedProfile(int studentId) {
            Student student = findStudentById(studentId); // Accessing outer class method
            if (student != null) {
                System.out.println("--- Detailed Profile ---");
                System.out.println(student.getProfile());
                System.out.println("Enrolled in " + student.getEnrolledCourses().size() + " courses.");
                System.out.println("------------------------");
            } else {
                System.out.println("Could not find student to print profile.");
            }
        }
    }

    public void printStudentProfile(int studentId) {
        ProfilePrinter printer = new ProfilePrinter();
        printer.printDetailedProfile(studentId);
    }
}