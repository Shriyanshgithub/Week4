package org.capgemini.InsurancePolicySystem2;

import java.time.LocalDate;
import java.util.*;

public class PolicyManagementSystem {
    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMapPolicies = new TreeMap<>();

    // Add a policy
    public void addPolicy(Policy policy) {
        // Add to HashMap
        hashMapPolicies.put(policy.getPolicyNumber(), policy);

        // Add to LinkedHashMap
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);

        // Add to TreeMap (grouped by expiry date)
        treeMapPolicies.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve a policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        treeMapPolicies.subMap(today, true, threshold, true)
                .values()
                .forEach(expiringPolicies::addAll);

        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove policies that are expired
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        // Remove expired policies from HashMap and LinkedHashMap
        hashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));

        // Remove expired policies from TreeMap
        treeMapPolicies.headMap(today, false).clear();
    }

    // List all policies (for debugging purposes)
    public void listAllPolicies() {
        System.out.println("HashMap Policies:");
        hashMapPolicies.values().forEach(System.out::println);

        System.out.println("\nLinkedHashMap Policies:");
        linkedHashMapPolicies.values().forEach(System.out::println);

        System.out.println("\nTreeMap Policies:");
        treeMapPolicies.values().forEach(System.out::println);
    }
}
