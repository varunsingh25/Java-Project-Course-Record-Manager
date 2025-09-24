package edu.ccrm.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * A utility class for file operations, demonstrating recursion.
 */
public class RecursiveFileUtils {

    /**
     * Recursively calculates the total size of a directory and its subdirectories.
     * Uses Files.walk and a Stream pipeline as a modern alternative to manual recursion.
     * @param path The directory path.
     * @return The total size in bytes.
     */
    public static long calculateDirectorySize(Path path) throws IOException {
        if (!Files.exists(path)) return 0;
        
        try (Stream<Path> walk = Files.walk(path)) {
            return walk
                .filter(Files::isRegularFile)
                .mapToLong(p -> {
                    try {
                        return Files.size(p);
                    } catch (IOException e) {
                        return 0L;
                    }
                })
                .sum();
        }
    }
}
