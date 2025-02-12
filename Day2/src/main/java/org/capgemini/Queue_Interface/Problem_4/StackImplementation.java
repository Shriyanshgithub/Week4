package org.capgemini.Queue_Interface.Problem_4;

public class StackImplementation {
    public static void main(String[] args) {
        // Create a stack and perform operations
        StackUsingTwoQueue stack = new StackUsingTwoQueue();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop and print the top element
        System.out.println("Popped element: " + stack.pop());

        // Get and print the top element
        System.out.println("Top element: " + stack.top());


    }
}

