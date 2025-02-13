/*
 Read User Input from Console
📌 Problem Statement:
Write a program that asks the user for their name, age, and favorite programming language, then saves this information into a file.
Requirements:
Use BufferedReader for console input.
Use FileWriter to write the data into a file.
Handle exceptions properly.

 */

package org.capgemini.Problem_3;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // Define the file path to save user data
        String outputFile = "user_data.txt";

        // Try-with-resources to handle resources safely
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("C:/Users/HP/Desktop/Week4/Day3/src/main/resources/file.txt")) {

            // Ask for user's name
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            // Ask for user's age
            System.out.print("Enter your age: ");
            String age = reader.readLine();

            // Ask for user's favorite programming language
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Write the user's data into the file
            writer.write("User Information:\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            // Notify the user that data has been saved
            System.out.println("Your information has been saved to " );

        } catch (IOException e) {
            // Handle exceptions
            System.err.println("An error occurred while reading input or writing to the file: " + e.getMessage());
        }
    }
}

