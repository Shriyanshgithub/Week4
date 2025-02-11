package org.capgemini.Set_Interface.Problem_3;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        // Input sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Compute symmetric difference
        Set<Integer> symmetricDifference = computeSymmetricDifference(set1, set2);

        // Output result
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }

    public static Set<Integer> computeSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> symmetricDifference = new HashSet<>();

        // Add elements from set1 that are not in set2
        for (Integer element : set1) {
            if (!set2.contains(element)) {
                symmetricDifference.add(element);
            }
        }

        // Add elements from set2 that are not in set1
        for (Integer element : set2) {
            if (!set1.contains(element)) {
                symmetricDifference.add(element);
            }
        }

        return symmetricDifference;
    }
}

