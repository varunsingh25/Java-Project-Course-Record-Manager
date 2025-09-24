package edu.ccrm.domain;

/**
 * An immutable value class for Course Codes.
 * Demonstrates: Immutability (final class, final fields, no setters).
 */
public final class CourseCode {
    private final String code;

    public CourseCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty.");
        }
        this.code = code.trim().toUpperCase();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCode that = (CourseCode) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
