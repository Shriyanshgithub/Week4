package org.capgemini.AdvancedProblem.FindRepeatingWord;

import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regex to match words
        String regex = "\\b(\\w+)\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Map to store word counts
        Map<String, Integer> wordCount = new HashMap<>();

        // Count occurrences of each word
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case-insensitive matching
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Extract repeating words
        List<String> repeatingWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        // Print repeating words
        System.out.println(String.join(", ", repeatingWords));
    }
}
