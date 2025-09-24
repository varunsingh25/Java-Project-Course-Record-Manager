// service/Persistable.java
package edu.ccrm.service;

public interface Persistable {
    void save();
    void load();

    default void log(String message) {
        System.out.println("[Persistable Log]: " + message);
    }
}
