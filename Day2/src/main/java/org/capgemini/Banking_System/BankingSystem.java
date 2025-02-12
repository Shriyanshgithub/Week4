package org.capgemini.Banking_System;

import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();           // HashMap to store account balances
    private TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>(); // TreeMap to sort by balance
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();   // Queue to process withdrawals

    // Method to add a new account
    public void addAccount(int accountNumber, double balance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }

        // Add to HashMap
        accounts.put(accountNumber, balance);

        // Add to TreeMap
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Method to update balance in TreeMap when account balance changes
    private void updateBalanceInTreeMap(int accountNumber, double oldBalance, double newBalance) {
        // Remove from old balance list
        List<Integer> accountsWithOldBalance = sortedAccounts.get(oldBalance);
        accountsWithOldBalance.remove((Integer) accountNumber);
        if (accountsWithOldBalance.isEmpty()) {
            sortedAccounts.remove(oldBalance);
        }

        // Add to new balance list
        sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Method to deposit money
    public void deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }

        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance + amount;

        // Update HashMap
        accounts.put(accountNumber, newBalance);

        // Update TreeMap
        updateBalanceInTreeMap(accountNumber, oldBalance, newBalance);

        System.out.println("Deposited $" + amount + " to account " + accountNumber);
    }

    // Method to add a withdrawal request
    public void requestWithdrawal(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }

        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request of $" + amount + " for account " + accountNumber + " added to the queue.");
    }

    // Method to process withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.accountNumber;
            double amount = request.amount;

            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Account " + accountNumber + " not found! Skipping...");
                continue;
            }

            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                double newBalance = balance - amount;

                // Update HashMap
                accounts.put(accountNumber, newBalance);

                // Update TreeMap
                updateBalanceInTreeMap(accountNumber, balance, newBalance);

                System.out.println("Processed withdrawal of $" + amount + " for account " + accountNumber);
            } else {
                System.out.println("Insufficient funds for account " + accountNumber);
            }
        }
    }

    // Method to display all accounts (HashMap)
    public void displayAllAccounts() {
        System.out.println("\nAll Accounts (HashMap):");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to display accounts sorted by balance (TreeMap)
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance (TreeMap):");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            for (Integer accountNumber : entry.getValue()) {
                System.out.println("Account " + accountNumber + ": $" + entry.getKey());
            }
        }
    }

    // WithdrawalRequest class for queue
    private static class WithdrawalRequest {
        int accountNumber;
        double amount;

        public WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }
}
