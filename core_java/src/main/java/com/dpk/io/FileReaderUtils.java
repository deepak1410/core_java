package com.dpk.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtils {

    public static List<String> readFile(String path) {

        List<String> fileContent = null;
        Path filePath = Paths.get(path);
        try {
            fileContent = Files.readAllLines(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileContent;
    }

    public static List<String> readFileUsingBufferedReader(String path) {
        List<String> fileContent = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null) {
                fileContent.add(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return fileContent;
    }

    public static void main(String[] args) {
        String path = "src/main/java/com/dpk/data/employees.csv";
        List<String> content = readFile(path);
        System.out.println("Number of lines in the file = " + content.size());

        List<String> contentUsingBufferedReader = readFileUsingBufferedReader(path);
        System.out.println("Number of lines in the files read by BufferedReader = " + contentUsingBufferedReader.size());
    }
}
