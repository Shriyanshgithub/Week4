package org.capgemini.VotingSystem;

import java.util.*;

public class VotingSystem {
    // To store votes (Candidate -> Votes)
    private Map<String, Integer> votesHashMap = new HashMap<>();
    // To maintain the order of votes
    private Map<String, Integer> votesLinkedHashMap = new LinkedHashMap<>();
    // To display results in sorted order
    private TreeMap<String, Integer> votesTreeMap = new TreeMap<>();

    // Method to cast a vote for a candidate
    public void castVote(String candidate) {
        // Update HashMap
        votesHashMap.put(candidate, votesHashMap.getOrDefault(candidate, 0) + 1);

        // Update LinkedHashMap
        votesLinkedHashMap.put(candidate, votesLinkedHashMap.getOrDefault(candidate, 0) + 1);

        // Update TreeMap
        votesTreeMap.put(candidate, votesTreeMap.getOrDefault(candidate, 0) + 1);
    }

    // Method to get votes in the form of a HashMap
    public Map<String, Integer> getVotesHashMap() {
        return votesHashMap;
    }

    // Method to get votes in the order they were cast (LinkedHashMap)
    public Map<String, Integer> getVotesLinkedHashMap() {
        return votesLinkedHashMap;
    }

    // Method to get votes in sorted order by candidate name (TreeMap)
    public Map<String, Integer> getVotesTreeMap() {
        return votesTreeMap;
    }

    // Method to display results in sorted order (TreeMap)
    public void displayResultsSorted() {
        System.out.println("\nResults (Sorted by Candidate Name):");
        for (Map.Entry<String, Integer> entry : votesTreeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Method to display votes in the order they were cast (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("\nVotes in Order Cast (LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : votesLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Method to display all votes (HashMap)
    public void displayAllVotes() {
        System.out.println("\nAll Votes (HashMap):");
        for (Map.Entry<String, Integer> entry : votesHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}

