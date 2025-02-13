/*

Filter Streams - Convert Uppercase to Lowercase
📌 Problem Statement:
Create a program that reads a text file and writes its contents into another file, converting all uppercase letters to lowercase.
Requirements:
Use FileReader and FileWriter.
Use BufferedReader and BufferedWriter for efficiency.
Handle character encoding issues.

 */


package org.capgemini.Problem_6;

import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        // Define input and output file paths
        String inputFile = "input.txt";  // Replace with your input file path
        String outputFile = "output.txt"; // Replace with your output file path

        // Use try-with-resources for automatic resource management
        try (
                FileReader fileReader = new FileReader(inputFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(outputFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            String line;
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Convert the line to lowercase
                String lowerCaseLine = line.toLowerCase();
                // Write the converted line to the output file
                bufferedWriter.write(lowerCaseLine);
                bufferedWriter.newLine(); // Add a newline to maintain the structure
            }
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            // Handle exceptions during file operations
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

