package org.example.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileOutput {
    public static List<String> readFile(String path) {
        try {
            Path pathNorm = Paths.get(path);
            if (!Files.exists(pathNorm)) {
                //System.out.println("Файл не найден: " + path);
                return List.of();
            }

            return Files.readAllLines(pathNorm);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении: " + e.toString());
        }
        return List.of();
    }
}
