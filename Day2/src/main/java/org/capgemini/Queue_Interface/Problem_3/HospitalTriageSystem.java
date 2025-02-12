package org.capgemini.Queue_Interface.Problem_3;

import java.util.*;

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Create a list of patients with their names and severity levels
        List<Patient> list = List.of(
                new Patient("John", 3),
                new Patient("Alice", 5),
                new Patient("Bob", 2)
        );

        // Get a priority queue of patients based on severity
        Queue<Patient> queue = getHigherSeverity(list);

        // Print the names of patients in order of severity (highest first)
        for (Patient patient : queue) {
            System.out.println(patient.name);
        }
    }

    // Method to create a priority queue of patients based on severity
    public static Queue<Patient> getHigherSeverity(List<Patient> list) {
        // Initialize a priority queue with a custom comparator for severity (descending order)
        Queue<Patient> patients = new PriorityQueue<>((a, b) -> b.severity - a.severity);

        // Add all patients from the list to the priority queue
        list.stream().forEach(p -> patients.add(p));

        // Return the priority queue
        return patients;
    }
}

// Class representing a patient with a name and severity level
class Patient {
    // Patient's name
    String name;
    // Severity level of the patient's condition
    int severity;

    // Constructor to initialize the patient's name and severity
    Patient(String s, int n) {
        name = s;
        severity = n;
    }
}
