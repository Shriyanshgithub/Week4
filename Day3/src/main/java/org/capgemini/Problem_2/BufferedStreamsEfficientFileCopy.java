package org.capgemini.Problem_2;

/*Buffered Streams - Efficient File Copy
        📌 Problem Statement:
        Create a Java program that copies a large file (e.g., 100MB) from one location to another using Buffered Streams (BufferedInputStream and BufferedOutputStream). Compare the performance with normal file streams.
        Requirements:
        Read and write in chunks of 4 KB (4096 bytes).
        Use System.nanoTime() to measure execution time.
        Compare execution time with unbuffered streams.*/

import java.io.*;

public class BufferedStreamsEfficientFileCopy {
        public static void main(String[] args) {
            // Paths to the source and destination files
            String sourceFile = "source_file_path_here";
            String destFileBuffered = "destination_buffered_file_path_here";
            String destFileUnbuffered = "destination_unbuffered_file_path_here";

            try {
                // Measure and execute file copy using Buffered Streams
                long bufferedTime = copyUsingBufferedStreams(sourceFile, destFileBuffered);

                // Measure and execute file copy using Unbuffered Streams
                long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, destFileUnbuffered);

                // Print execution times for comparison
                System.out.println("Buffered Streams Time: " + bufferedTime + " nanoseconds");
                System.out.println("Unbuffered Streams Time: " + unbufferedTime + " nanoseconds");

            } catch (IOException e) {
                System.out.println("An error occurred during file copy: " + e.getMessage());
            }
        }

        // Copy file using BufferedInputStream and BufferedOutputStream
        private static long copyUsingBufferedStreams(String source, String dest) throws IOException {
            long startTime = System.nanoTime();

            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

                byte[] buffer = new byte[4096]; // 4 KB buffer
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }

            long endTime = System.nanoTime();
            return endTime - startTime;
        }

        // Copy file using unbuffered FileInputStream and FileOutputStream
        private static long copyUsingUnbufferedStreams(String source, String dest) throws IOException {
            long startTime = System.nanoTime();

            try (FileInputStream fis = new FileInputStream(source);
                 FileOutputStream fos = new FileOutputStream(dest)) {

                byte[] buffer = new byte[4096]; // 4 KB buffer
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            long endTime = System.nanoTime();
            return endTime - startTime;
        }
    }

