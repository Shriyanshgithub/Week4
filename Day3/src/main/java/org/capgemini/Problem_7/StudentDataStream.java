/*
. Data Streams - Store and Retrieve Primitive Data
📌 Problem Statement:
Write a Java program that stores student details (roll number, name, GPA) in a binary file and retrieves it later.
Requirements:
Use DataOutputStream to write primitive data.
Use DataInputStream to read data.
Ensure proper closing of resources.

 */

package org.capgemini.Problem_7;

import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        // Binary file to store student details
        String fileName = "C:/Users/HP/Desktop/Week4/Day3/src/main/resources/file2.txt";

        // Student details to store
        int rollNumber = 101;
        String name = "John Doe";
        double gpa = 3.8;

        // Writing student details to the binary file
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            dataOutputStream.writeInt(rollNumber); // Write roll number
            dataOutputStream.writeUTF(name);       // Write name
            dataOutputStream.writeDouble(gpa);     // Write GPA
            System.out.println("Student details have been stored successfully.");
        } catch (IOException e) {
            System.err.println("Error writing student details: " + e.getMessage());
        }

        // Reading student details from the binary file
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            int retrievedRollNumber = dataInputStream.readInt(); // Read roll number
            String retrievedName = dataInputStream.readUTF();    // Read name
            double retrievedGpa = dataInputStream.readDouble();  // Read GPA

            System.out.println("Retrieved Student Details:");
            System.out.println("Roll Number: " + retrievedRollNumber);
            System.out.println("Name: " + retrievedName);
            System.out.println("GPA: " + retrievedGpa);
        } catch (IOException e) {
            System.err.println("Error reading student details: " + e.getMessage());
        }
    }
}
