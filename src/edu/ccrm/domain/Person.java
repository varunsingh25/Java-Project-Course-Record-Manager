package edu.ccrm.domain;

import java.util.Objects;

/**
 * An abstract base class representing a person in the CCRM system.
 * Demonstrates: Abstraction, Encapsulation.
 */
public abstract class Person {
    private static int idCounter = 1;
    private int personId;
    private String fullName;
    private String email;

    public Person(int personId, String fullName, String email) {
        this.personId = (personId == 0) ? idCounter++ : personId;
        this.fullName = fullName;
        this.email = email;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getProfile();

    // Getters and Setters (Encapsulation)
    public int getPersonId() { return personId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ID=" + personId + ", Name='" + fullName + "', Email='" + email + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }
}