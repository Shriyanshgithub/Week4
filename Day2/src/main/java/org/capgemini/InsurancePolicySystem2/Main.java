package org.capgemini.InsurancePolicySystem2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();

        // Add sample policies
        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().minusDays(5), "Auto", 700));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().plusDays(25), "Home", 1000));
        system.addPolicy(new Policy("P004", "Charlie", LocalDate.now().plusDays(50), "Health", 800));

        // Retrieve a policy by its number
        System.out.println("Policy P001:");
        System.out.println(system.getPolicyByNumber("P001"));

        // List all policies expiring within the next 30 days
        System.out.println("\nPolicies expiring within the next 30 days:");
        system.getPoliciesExpiringSoon().forEach(System.out::println);

        // List all policies for a specific policyholder
        System.out.println("\nPolicies for Alice:");
        system.getPoliciesByPolicyholder("Alice").forEach(System.out::println);

        // Remove expired policies
        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();

        // List all policies after removal
        System.out.println("\nAll policies after removing expired ones:");
        system.listAllPolicies();
    }
}

