package org.capgemini.List_Interface.Problem_5;

import java.util.LinkedList;

public class NthElementFromEnd {
    public static void main(String[] args) {
        // Input linked list and N value
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        int N = 2;

        // Find and print the Nth element from the end
        String result = findNthFromEnd(list, N);
        if (result != null) {
            System.out.println("The " + N + "th element from the end is: " + result); // Output: D
        } else {
            System.out.println("Invalid value of N.");
        }
    }

    public static String findNthFromEnd(LinkedList<String> list, int N) {
        // Two-pointer approach
        var firstPointer = list.listIterator();
        var secondPointer = list.listIterator();

        // Move the first pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (firstPointer.hasNext()) {
                firstPointer.next();
            } else {
                // If N is greater than the size of the list
                return null;
            }
        }

        // Move both pointers one step at a time until the first pointer reaches the end
        while (firstPointer.hasNext()) {
            firstPointer.next();
            secondPointer.next();
        }

        // Second pointer is now at the Nth element from the end
        return secondPointer.next();
    }
}

