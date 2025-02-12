package org.capgemini.Queue_Interface.Problem_4;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    StackUsingTwoQueue(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x) {
        // Add the new element to queue2
        queue2.add(x);

        // Move all elements from queue1 to queue2 to maintain stack order
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the queues so queue1 becomes the active stack representation
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }


        public int pop() {
            if (queue1.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            return queue1.remove();
        }

    // Get the top element of the stack
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return queue1.peek();
    }

}
