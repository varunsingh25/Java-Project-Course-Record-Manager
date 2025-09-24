package edu.ccrm.domain;

/**
 * Represents a course.
 * Demonstrates: Builder Pattern (via static nested class), Composition (uses CourseCode).
 */
public class Course {
    private final CourseCode code;
    private final String title;
    private final int credits;
    private final String department;
    private Semester semester;
    private Instructor instructor;

    // Private constructor to enforce builder usage
    private Course(CourseBuilder builder) {
        this.code = new CourseCode(builder.code);
        this.title = builder.title;
        this.credits = builder.credits;
        this.department = builder.department;
        this.semester = builder.semester;
    }

    // Getters
    public CourseCode getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("Course [Code=%s, Title='%s', Credits=%d, Dept='%s']", code, title, credits, department);
    }

    /**
     * Demonstrates the Builder design pattern using a static nested class.
     * This allows for flexible and readable construction of complex objects.
     */
    public static class CourseBuilder {
        private final String code;
        private final String title;
        private int credits = 3; // default value
        private String department = "General"; // default value
        private Semester semester;

        public CourseBuilder(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public CourseBuilder credits(int credits) {
            // Assertion to check for class invariants
            assert credits > 0 && credits <= 5 : "Credits must be between 1 and 5";
            this.credits = credits;
            return this;
        }

        public CourseBuilder department(String department) {
            this.department = department;
            return this;
        }

        public CourseBuilder semester(Semester semester) {
            this.semester = semester;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}