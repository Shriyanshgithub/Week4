package org.capgemini.Set_Interface.Problem_4;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        // Input HashSet
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        // Convert to sorted list
        List<Integer> sortedList = convertToSortedList(set);

        // Output result
        System.out.println("Sorted List: " + sortedList);
    }

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        // Create a list from the set
        List<Integer> list = new ArrayList<>(set);

        // Sort the list in ascending order
        Collections.sort(list);

        return list;
    }
}

