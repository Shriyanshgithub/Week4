package org.capgemini.Map_Interface.Problem_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertTheMap {
    public static void main(String[] args) {
        // Initialize a HashMap with key-value pairs
        HashMap<Character, Integer> map = new HashMap<>(Map.of('A', 1, 'B', 2, 'C', 1));

        // Call the method to invert the map
        getReverseMap(map);
    }

    public static void getReverseMap(HashMap<Character, Integer> map) {
        // Create a new HashMap to store the inverted map (value as key, keys as list)
        HashMap<Integer, List<Character>> myMap = new HashMap<>();

        // Iterate over each entry in the original map
        for (Map.Entry<Character, Integer> element : map.entrySet()) {
            // Get the value (new key) from the original map
            int key = element.getValue();

            // Get the existing list for the new key or create a new list if not present
            List<Character> list = myMap.containsKey(key) ? myMap.get(key) : new ArrayList<>();

            // Add the original key (character) to the list
            list.add(element.getKey());

            // Update the inverted map with the new key and list
            myMap.put(key, list);
        }

        // Print the inverted map
        System.out.println(myMap);
    }
}
