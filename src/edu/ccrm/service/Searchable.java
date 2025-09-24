// service/Searchable.java
package edu.ccrm.service;

import java.util.List;

public interface Searchable<T> {
    List<T> search(String keyword);

    default void log(String message) {
        System.out.println("[Searchable Log]: " + message);
    }
}
