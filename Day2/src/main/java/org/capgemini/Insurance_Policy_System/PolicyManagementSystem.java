package org.capgemini.Insurance_Policy_System;

import java.time.LocalDate;
import java.util.*;

public class PolicyManagementSystem {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public Set<Policy> getHashSetPolicies() {
        return hashSetPolicies;
    }

    public Set<Policy> getLinkedHashSetPolicies() {
        return linkedHashSetPolicies;
    }

    public Set<Policy> getTreeSetPolicies() {
        return treeSetPolicies;
    }

    public void comparePerformance() {
        int numPolicies = 100000;
        List<Policy> samplePolicies = new ArrayList<>();

        for (int i = 0; i < numPolicies; i++) {
            samplePolicies.add(new Policy("PN" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 1000 + i));
        }

        long startTime, endTime;

        // HashSet
        startTime = System.nanoTime();
        Set<Policy> hashSet = new HashSet<>(samplePolicies);
        endTime = System.nanoTime();
        System.out.println("HashSet add: " + (endTime - startTime) + " ns");

        // LinkedHashSet
        startTime = System.nanoTime();
        Set<Policy> linkedHashSet = new LinkedHashSet<>(samplePolicies);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet add: " + (endTime - startTime) + " ns");

        // TreeSet
        startTime = System.nanoTime();
        Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
        treeSet.addAll(samplePolicies);
        endTime = System.nanoTime();
        System.out.println("TreeSet add: " + (endTime - startTime) + " ns");
    }

    public List<Policy> getPoliciesExpiringSoon(Set<Policy> policies) {
        List<Policy> expiringSoon = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);

        for (Policy policy : policies) {
            if (policy.getExpiryDate().isBefore(threshold)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByCoverageType(Set<Policy> policies, String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    public Set<Policy> findDuplicatePolicies(List<Policy> policies) {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> seenPolicyNumbers = new HashSet<>();

        for (Policy policy : policies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

}

