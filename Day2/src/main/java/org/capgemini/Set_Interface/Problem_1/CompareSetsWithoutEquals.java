package org.capgemini.Set_Interface.Problem_1;

import java.util.HashSet;
import java.util.Set;

public class CompareSetsWithoutEquals {
    public static void main(String[] args) {
        // Input sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Compare sets and print the result
        boolean areEqual = areSetsEqual(set1, set2);
        System.out.println("Are the sets equal? " + areEqual); // Output: true
    }

    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        // Check if sizes are the same
        if (set1.size() != set2.size()) {
            return false;
        }

        // Check if all elements in set1 are in set2
        for (Integer element : set1) {
            if (!set2.contains(element)) {
                return false;
            }
        }

        return true; // Sets are equal
    }
}

