package org.capgemini.Problem_5;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a job role
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getRoleSpecificDetails();

    @Override
    public String toString() {
        return "Candidate: " + candidateName + ", " + getRoleSpecificDetails();
    }
}

// Subclass for Software Engineer role
class SoftwareEngineer extends JobRole {
    private String primaryProgrammingLanguage;

    public SoftwareEngineer(String candidateName, String primaryProgrammingLanguage) {
        super(candidateName);
        this.primaryProgrammingLanguage = primaryProgrammingLanguage;
    }

    @Override
    public String getRoleSpecificDetails() {
        return "Role: Software Engineer, Primary Language: " + primaryProgrammingLanguage;
    }
}

// Subclass for Data Scientist role
class DataScientist extends JobRole {
    private String primaryTool;

    public DataScientist(String candidateName, String primaryTool) {
        super(candidateName);
        this.primaryTool = primaryTool;
    }

    @Override
    public String getRoleSpecificDetails() {
        return "Role: Data Scientist, Primary Tool: " + primaryTool;
    }
}

// Subclass for Product Manager role
class ProductManager extends JobRole {
    private int yearsOfExperience;

    public ProductManager(String candidateName, int yearsOfExperience) {
        super(candidateName);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String getRoleSpecificDetails() {
        return "Role: Product Manager, Years of Experience: " + yearsOfExperience;
    }
}

// Generic Resume class to process resumes for specific job roles
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return jobRole.toString();
    }
}

// Resume screening utility class
class ResumeScreening {
    // Generic method to validate and process resumes
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing resume for: " + resume.getJobRole().getCandidateName());
        System.out.println(resume);
        System.out.println("Resume successfully processed!\n");
    }

    // Method to screen resumes dynamically using wildcards
    public static void screenResumes(List<? extends JobRole> jobRoles) {
        System.out.println("Screening resumes...");
        for (JobRole role : jobRoles) {
            System.out.println(role);
        }
        System.out.println("All resumes screened!\n");
    }
}

// Main class to demonstrate functionality
public class AIResumeScreeningSystem {
    public static void main(String[] args) {
        // Create resumes for different job roles
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", "Java"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", "Python"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 5));

        // Process individual resumes
        ResumeScreening.processResume(seResume);
        ResumeScreening.processResume(dsResume);
        ResumeScreening.processResume(pmResume);

        // Add all job roles to a list for batch screening
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(seResume.getJobRole());
        jobRoles.add(dsResume.getJobRole());
        jobRoles.add(pmResume.getJobRole());

        // Screen resumes dynamically
        ResumeScreening.screenResumes(jobRoles);
    }
}

