package edu.ccrm.service;

import java.util.Collections;
import java.util.List;

/**
 * This class demonstrates resolving the "diamond problem"
 * that arises from multiple interfaces having default methods
 * with the same signature.
 */
public class DataArchiver implements Searchable<String>, Persistable {

    @Override
    public List<String> search(String keyword) {
        System.out.println("Searching archives...");
        return Collections.emptyList();
    }

    @Override
    public void save() {
        System.out.println("Saving archive...");
    }

    @Override
    public void load() {
        System.out.println("Loading archive...");
    }

    // Explicitly override the conflicting default method
    @Override
    public void log(String message) {
        System.out.println("[DataArchiver Main Log]: " + message);
        // You can also explicitly call an interface's implementation
        Persistable.super.log(message);
    }
}