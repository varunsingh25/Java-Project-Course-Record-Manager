package edu.ccrm.exception;

/**
 * A custom checked exception for duplicate enrollment attempts.
 */
public class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException(String message) {
        super(message);
    }
}