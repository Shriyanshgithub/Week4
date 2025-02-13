package org.capgemini.Problem_9;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "C:/Users/HP/Desktop/Week4/Day3/src/main/resources/file.txt";

        // Word to search for
        String keyword = "error";

        // Read the file line by line
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;
                // Check if the line contains the keyword (case insensitive)
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("The file was not found: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

