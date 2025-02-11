package org.capgemini.Set_Interface.Problem_2;

import java.util.HashSet;
import java.util.Set;

public class UnionIntersectionWithoutMethods {
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

        // Compute union and intersection
        Set<Integer> union = computeUnion(set1, set2);
        Set<Integer> intersection = computeIntersection(set1, set2);

        // Output results
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }

    public static Set<Integer> computeUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>();

        // Add all elements from set1
        for (Integer element : set1) {
            union.add(element);
        }

        // Add elements from set2 if not already in union
        for (Integer element : set2) {
            if (!union.contains(element)) {
                union.add(element);
            }
        }

        return union;
    }

    public static Set<Integer> computeIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>();

        // Add elements that are present in both sets
        for (Integer element : set1) {
            if (set2.contains(element)) {
                intersection.add(element);
            }
        }

        return intersection;
    }
}

