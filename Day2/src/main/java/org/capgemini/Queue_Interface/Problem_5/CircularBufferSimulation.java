package org.capgemini.Queue_Interface.Problem_5;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class CircularBufferSimulation {
    public static void main(String[] args) {
        // Maximum buffer size
        final int SIZE = 3;
        // Initialize queue
        Queue<Integer> queue = new ArrayDeque<>(List.of(1, 2, 3, 4, 5, 6));

        // Add element to buffer, overwriting oldest if full
        OverwriteQueue(queue, SIZE, 10);

        // Print updated queue
        System.out.println(queue);
    }

    // Simulates adding elements to a circular buffer
    public static void OverwriteQueue(Queue<Integer> queue, int SIZE, int element) {
        // Check if the queue has space; add the new element if it does
        if (queue.size() < SIZE) {
            // Add element to the queue
            queue.offer(element);
            return;
        }

        // Remove extra elements to ensure the queue size matches the buffer size
        while (queue.size() != SIZE) {
            queue.poll(); // Remove elements from the front of the queue
        }

        // Remove the oldest element to make space for the new one
        queue.poll();

        // Add the new element to the queue
        queue.offer(element);
    }
}
