package org.capgemini.Set_Interface.Problem_5;

import java.util.HashSet;
import java.util.Set;

public class SubsetCheck {
    public static void main(String[] args) {
        // Input sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if set1 is a subset of set2
        boolean isSubset = isSubsetOf(set1, set2);

        // Output result
        System.out.println("Is set1 a subset of set2? " + isSubset); // Output: true
    }

    public static boolean isSubsetOf(Set<Integer> subset, Set<Integer> superset) {
        // Check if every element in subset exists in superset
        for (Integer element : subset) {
            if (!superset.contains(element)) {
                return false;
            }
        }
        return true;
    }
}
