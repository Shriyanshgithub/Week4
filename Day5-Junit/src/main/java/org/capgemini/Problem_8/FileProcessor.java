package org.capgemini.Problem_8;

import java.io.*;

public class FileProcessor {

    // Write content to a file using FileWriter and BufferedWriter
    public void writeToFile(String filename, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
        }
    }

    // Read content from a file using BufferedReader
    public String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim(); // Trim to remove last newline
    }
}

