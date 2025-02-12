package org.capgemini.Queue_Interface.Problem_1;

import java.util.Queue;
import java.util.LinkedList;

public class ReverseTheQueue {
    // Method to reverse the elements of the queue recursively
    public static void reverseQueue(Queue<Integer> queue) {
        // Base case: if the queue is empty, return
        if (queue.isEmpty()) {
            return;
        }
        // Remove the front element from the queue
        int front = queue.remove();

        // Recursively reverse the remaining queue
        reverseQueue(queue);

        // Add the removed element to the end of the queue
        queue.add(front);
    }

    public static void main(String[] args) {
        // Create a queue and add elements to it
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }

        // Print the original queue
        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Print the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}
