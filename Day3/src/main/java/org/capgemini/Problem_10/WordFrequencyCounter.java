package org.capgemini.Problem_10;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Path to the input file
        String filePath = "input.txt"; // Replace with your file path

        // HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read the file and count words
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words and normalize them (case-insensitive)
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) { // Ignore empty strings
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file was not found: " + filePath);
            return;
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        // Calculate total words
        int totalWords = 0;
        for (int count : wordCountMap.values()) {
            totalWords += count;
        }
        System.out.println("Total Words: " + totalWords);

        // Sort words by frequency
        List<Map.Entry<String, Integer>> sortedWordList = new ArrayList<>(wordCountMap.entrySet());
        Collections.sort(sortedWordList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue()); // Descending order
            }
        });

        // Display the top 5 most frequent words
        System.out.println("\nTop 5 Most Frequent Words:");
        for (int i = 0; i < Math.min(5, sortedWordList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWordList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

