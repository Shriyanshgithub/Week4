package org.capgemini.List_Interface.Problem_3;

import java.util.*;

public class ListRotation {
    public static void main(String[] args) {
        // Input list and rotation value
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        // Output rotated list
        List<Integer> rotatedList = rotateList(list, rotateBy);
        System.out.println(rotatedList); // Output: [30, 40, 50, 10, 20]
    }

    public static List<Integer> rotateList(List<Integer> list, int rotateBy) {
        int n = list.size();
        // Handle cases where rotateBy is greater than size or negative
        rotateBy = (rotateBy % n + n) % n;

        // Rotate using sublists
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(rotateBy, n));
        rotated.addAll(list.subList(0, rotateBy));

        return rotated;
    }
}
