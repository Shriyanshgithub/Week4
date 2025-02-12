package org.capgemini.Insurance_Policy_System;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();

        // Add policies
        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 700));
        system.addPolicy(new Policy("P003", "Charlie", LocalDate.now().plusDays(5), "Home", 1000));

        // Retrieve policies expiring soon
        List<Policy> expiringSoon = system.getPoliciesExpiringSoon(system.getTreeSetPolicies());
        System.out.println("Policies expiring soon: " + expiringSoon);

        // Retrieve policies by coverage type
        List<Policy> healthPolicies = system.getPoliciesByCoverageType(system.getHashSetPolicies(), "Health");
        System.out.println("Health Policies: " + healthPolicies);

        // Compare performance
        system.comparePerformance();
    }
}

