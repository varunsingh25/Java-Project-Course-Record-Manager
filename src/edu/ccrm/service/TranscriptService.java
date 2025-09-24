package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Person; // Using base class reference
import edu.ccrm.domain.Student;

public class TranscriptService {
    public String generateTranscript(Student student) {
        // Demonstration of Upcasting (Student is treated as a Person)
        Person person = student;
        
        StringBuilder sb = new StringBuilder();
        sb.append("--- OFFICIAL TRANSCRIPT ---\n");
        sb.append(person.getProfile()).append("\n"); // Polymorphic method call
        sb.append("---------------------------\n");
        sb.append(String.format("%-10s | %-30s | %-7s | %-5s\n", "Code", "Course Title", "Credits", "Grade"));
        sb.append("-----------------------------------------------------------\n");
        
        for (Enrollment e : student.getEnrolledCourses()) {
            sb.append(String.format("%-10s | %-30s | %-7d | %-5s\n",
                    e.getCourse().getCode(),
                    e.getCourse().getTitle(),
                    e.getCourse().getCredits(),
                    e.getGrade() != null ? e.getGrade().name() : "N/A"));
        }

        sb.append("-----------------------------------------------------------\n");
        sb.append(String.format("Cumulative GPA: %.2f\n", student.calculateGpa()));
        return sb.toString();
    }
}