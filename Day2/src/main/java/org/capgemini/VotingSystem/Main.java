package org.capgemini.VotingSystem;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Cast votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        // Display all votes (HashMap)
        votingSystem.displayAllVotes();

        // Display votes in order they were cast (LinkedHashMap)
        votingSystem.displayVotesInOrder();

        // Display results in sorted order (TreeMap)
        votingSystem.displayResultsSorted();
    }
}

