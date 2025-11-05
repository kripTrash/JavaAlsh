package org.example.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileInput {
    public static boolean writeFile(String fileName, String text) {
        try {
            Path path = Paths.get(fileName);
            Files.write(path, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при записи: " + e.toString());
        }
        return false;
    }
}