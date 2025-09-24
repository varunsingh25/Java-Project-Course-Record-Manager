package edu.ccrm.config;

import java.util.Properties;

/**
 * Application configuration manager implemented using the Singleton pattern.
 * This ensures that there is only one instance of configuration settings
 * throughout the application.
 */
public class AppConfig {
    private static AppConfig instance;
    private final Properties properties;

    // Private constructor to prevent instantiation
    private AppConfig() {
        properties = new Properties();
        // Set default values
        properties.setProperty("data.directory.path", "test-data");
        properties.setProperty("export.directory.path", "data/exports");
        properties.setProperty("backup.directory.path", "data/backups");
    }

    /**
     * Provides the global access point to the Singleton instance.
     */
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
