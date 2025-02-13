/*
ByteArray Stream - Convert Image to ByteArray
📌 Problem Statement:
Write a Java program that converts an image file into a byte array and then writes it back to another image file.
Requirements:
Use ByteArrayInputStream and ByteArrayOutputStream.
Verify that the new file is identical to the original image.
Handle IOException.

 */

package org.capgemini.Problem_5;

import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        // Paths for the original and new image files
        String sourceImagePath = "source_image.jpg";
        String newImagePath = "new_image.jpg";

        try {
            // Step 1: Convert image file to byte array
            byte[] imageBytes = convertImageToByteArray(sourceImagePath);

            // Step 2: Write byte array back to a new image file
            writeByteArrayToImage(imageBytes, newImagePath);

            // Step 3: Verify that the original and new files are identical
            boolean isIdentical = verifyFiles(sourceImagePath, newImagePath);
            if (isIdentical) {
                System.out.println("The original and new image files are identical.");
            } else {
                System.out.println("The original and new image files are not identical.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to convert an image file to a byte array
    private static byte[] convertImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;

            // Read the file into the ByteArrayOutputStream
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    // Method to write a byte array back to an image file
    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;

            // Write the byte array to the file
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("New image file has been created at: " + filePath);
        }
    }

    // Method to verify if two files are identical
    private static boolean verifyFiles(String filePath1, String filePath2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(filePath1);
             FileInputStream fis2 = new FileInputStream(filePath2)) {

            byte[] buffer1 = new byte[4096];
            byte[] buffer2 = new byte[4096];

            int bytesRead1, bytesRead2;

            // Compare both files byte by byte
            while ((bytesRead1 = fis1.read(buffer1)) != -1 &&
                    (bytesRead2 = fis2.read(buffer2)) != -1) {
                if (bytesRead1 != bytesRead2 || !Arrays.equals(buffer1, buffer2)) {
                    return false;
                }
            }

            // Ensure both files are completely read
            return fis1.read() == -1 && fis2.read() == -1;
        }
    }
}

