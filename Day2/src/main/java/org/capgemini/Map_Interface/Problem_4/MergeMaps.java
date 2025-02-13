package org.capgemini.Map_Interface.Problem_4;

import java.util.*;


public class MergeMaps {
    public static void main(String[] args) {
        // Example input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Output the result
        System.out.println("Merged Map: " + mergedMap);
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create a new map to store the merged result
        Map<String, Integer> result = new HashMap<>(map1);

        // Merge map2 into the result
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            // If the key already exists, add the values, otherwise put the new key-value pair
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }

        return result;
    }
}
