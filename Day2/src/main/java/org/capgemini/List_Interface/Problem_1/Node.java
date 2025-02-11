package org.capgemini.List_Interface.Problem_1;

// Define the Node class
public class Node {
    // Variable to store the data in the node
    int data;

    // Reference to the next node in the list
    Node next;

    // Constructor to initialize the node with the provided data
    public Node(int data) {
        // Assign the provided data to the node
        this.data = data;
        // Set the next reference to null initially
        next = null;
    }
}

// Define the ReversedLinkedList class
class ReversedLinkedList {
    // Head of the reversed linked list
    Node head;

    // Constructor to initialize the reversed linked list by reversing a given linked list
    public ReversedLinkedList(Node node) {
        // Reverse the linked list using recursion
        this.head = reverseLinkedListRecursion(node);
    }

    // Private method to reverse the linked list recursively
    private Node reverseLinkedListRecursion(Node current) {
        // Base case
        if (current == null || current.next == null) {
            return current;
        }

        // Recursive call
        Node newCurrent = reverseLinkedListRecursion(current.next);

        Node temp = current.next;
        temp.next = current;
        current.next = null;
        return newCurrent;
    }

    // Method to print the elements of the linked list
    void printLinkedList() {
        // Start from the head of the list
        Node temp = head;

        // Traverse the list and print each node's data
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
