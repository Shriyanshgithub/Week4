package org.capgemini.Queue_Interface.Problem_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static List<String> generateBinaryNumbers(int N) {
        // List to store binary numbers
        List<String> result = new ArrayList<>();
        // Queue to generate binary numbers
        Queue<String> queue = new LinkedList<>();

        // Add the first binary number
        queue.add("1");

        for (int i = 0; i < N; i++) {
            // Remove the front element
            String current = queue.poll();
            // Add the current binary number to the result
            result.add(current);

            // Generate the next two binary numbers by appending "0" and "1"
            queue.add(current + "0");
            queue.add(current + "1");
        }

        // Return the list of binary numbers
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        // Generate binary numbers
        List<String> binaryNumbers = generateBinaryNumbers(N);

        System.out.println(binaryNumbers);
    }
}

