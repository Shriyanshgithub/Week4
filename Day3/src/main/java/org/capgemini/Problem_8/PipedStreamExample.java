package org.capgemini.Problem_8;

import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            // Create writer and reader threads
            Thread writerThread = new Thread(new WriterTask(pipedOutputStream), "WriterThread");
            Thread readerThread = new Thread(new ReaderTask(pipedInputStream), "ReaderThread");

            // Start both threads
            writerThread.start();
            readerThread.start();

            // Wait for threads to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

// Writer task to write data to the PipedOutputStream
class WriterTask implements Runnable {
    private final PipedOutputStream pipedOutputStream;

    public WriterTask(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try (pipedOutputStream) {
            for (int i = 1; i <= 5; i++) {
                String data = "Message " + i;
                pipedOutputStream.write(data.getBytes());
                System.out.println(Thread.currentThread().getName() + " wrote: " + data);
                Thread.sleep(500); // Simulate delay in writing
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " encountered an error: " + e.getMessage());
        }
    }
}

// Reader task to read data from the PipedInputStream
class ReaderTask implements Runnable {
    private final PipedInputStream pipedInputStream;

    public ReaderTask(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try (pipedInputStream) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = pipedInputStream.read(buffer)) != -1) {
                String receivedData = new String(buffer, 0, bytesRead);
                System.out.println(Thread.currentThread().getName() + " read: " + receivedData);
            }
        } catch (IOException e) {
            System.err.println(Thread.currentThread().getName() + " encountered an error: " + e.getMessage());
        }
    }
}

