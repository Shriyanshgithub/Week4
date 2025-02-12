package org.capgemini.Banking_System;

public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        // Add accounts
        bankingSystem.addAccount(101, 5000.0);
        bankingSystem.addAccount(102, 3000.0);
        bankingSystem.addAccount(103, 7000.0);

        // Display all accounts
        bankingSystem.displayAllAccounts();

        // Display accounts sorted by balance
        bankingSystem.displayAccountsSortedByBalance();

        // Deposit money
        bankingSystem.deposit(102, 2000.0);

        // Display accounts after deposit
        bankingSystem.displayAllAccounts();
        bankingSystem.displayAccountsSortedByBalance();

        // Add withdrawal requests
        bankingSystem.requestWithdrawal(101, 1000.0);
        bankingSystem.requestWithdrawal(103, 8000.0); // Exceeds balance
        bankingSystem.requestWithdrawal(102, 4000.0);

        // Process withdrawals
        bankingSystem.processWithdrawals();

        // Display accounts after processing withdrawals
        bankingSystem.displayAllAccounts();
        bankingSystem.displayAccountsSortedByBalance();
    }
}
