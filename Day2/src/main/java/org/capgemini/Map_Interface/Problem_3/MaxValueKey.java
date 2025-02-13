package org.capgemini.Map_Interface.Problem_3;

import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        // Example input
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Find the key with the maximum value
        String keyWithMaxValue = findKeyWithMaxValue(map);

        // Output the result
        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        // Initialize variables to track the maximum value and corresponding key
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}

