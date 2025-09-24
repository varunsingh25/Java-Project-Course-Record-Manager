package edu.ccrm.domain;

public class Instructor extends Person {
    private String specialization;

    public Instructor(int personId, String fullName, String email, String specialization) {
        super(personId, fullName, email);
        this.specialization = specialization;
    }

    @Override
    public String getProfile() {
        return "Instructor Profile: " + getFullName() + " - Specialization: " + specialization;
    }
}