package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Manages backup operations using the NIO.2 API.
 * Demonstrates: Path, Files, DateTime API.
 */
public class BackupService {

    private static final Path BACKUP_ROOT = Path.of(AppConfig.getInstance().getProperty("backup.directory.path"));
    private static final Path EXPORT_ROOT = Path.of(AppConfig.getInstance().getProperty("export.directory.path"));

    public static Path performBackup() throws IOException {
        // Use Date/Time API for a timestamped folder name
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        Path backupDir = BACKUP_ROOT.resolve("backup_" + timestamp);

        Files.createDirectories(backupDir);

        // Use Files.walk in a try-with-resources block to copy files
        try (Stream<Path> stream = Files.walk(EXPORT_ROOT)) {
            stream.filter(Files::isRegularFile).forEach(source -> {
                try {
                    Files.copy(source, backupDir.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException("Could not copy file: " + source, e);
                }
            });
        }
        return backupDir;
    }
    
    public static Path getBackupRoot() {
        return BACKUP_ROOT;
    }
}