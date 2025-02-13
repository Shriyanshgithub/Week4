package org.capgemini.Map_Interface.Problem_1;

import java.util.*;

public class WordFrequencyCounter {

    public static <K, V> void main(String[] args) {
        // Input string to calculate word frequency
        String str = "Hello world, hello Java!";

        // Convert string to lowercase, trim extra spaces, and split into words
        String[] s = str.toLowerCase().trim().split("\\s+");

        // List
        List<String> list = new ArrayList<>();

        // Loop through each word and remove non-alphabetic characters
        for (String words : s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length(); i++) {
                // Check if character is a lowercase letter (a-z)
                if (words.charAt(i) >= 97 && words.charAt(i) <= 122) {
                    sb.append(words.charAt(i));
                }
            }
            // Add cleaned word to the list
            list.add(String.valueOf(sb));
        }

        // Count the frequency of words in the list
        Map<String, Integer> map = countword(list);

        // Print the word frequency map
        System.out.println(map);
    }

    // Method to count the frequency of words in a list
    public static Map<String, Integer> countword(List<String> ls) {
        // Initialize a HashMap to store word frequencies
        HashMap<String, Integer> map = new HashMap<>();

        // Loop through the list and update the frequency count in the map
        for (String s : ls) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Return the map with word frequencies
        return (Map<String, Integer>) map;
    }
}
