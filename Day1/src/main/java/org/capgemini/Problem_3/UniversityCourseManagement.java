package org.capgemini.Problem_3;

import java.util.ArrayList;
import java.util.List;

// Generic Course class managing specific course types
class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseType.toString();
    }
}

// Utility class to manage courses dynamically
class CourseManager {
    // Method to print details of courses using wildcards
    public static void printCourseDetails(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

// Main class to demonstrate functionality
public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Create lists to store different types of courses
        List<CourseType> allCourses = new ArrayList<>();
        List<ExamCourse> examCourses = new ArrayList<>();
        List<AssignmentCourse> assignmentCourses = new ArrayList<>();
        List<ResearchCourse> researchCourses = new ArrayList<>();

        // Add courses to respective lists
        examCourses.add(new ExamCourse("Mathematics 101", "Mathematics", 70));
        assignmentCourses.add(new AssignmentCourse("Programming 101", "Computer Science", 5));
        researchCourses.add(new ResearchCourse("Quantum Computing", "Physics", "Quantum Algorithms"));

        // Add all courses to a generic list for dynamic management
        allCourses.addAll(examCourses);
        allCourses.addAll(assignmentCourses);
        allCourses.addAll(researchCourses);

        // Print details of all courses
        System.out.println("All Courses:");
        CourseManager.printCourseDetails(allCourses);

        System.out.println("\nExam-Based Courses:");
        CourseManager.printCourseDetails(examCourses);

        System.out.println("\nAssignment-Based Courses:");
        CourseManager.printCourseDetails(assignmentCourses);

        System.out.println("\nResearch-Based Courses:");
        CourseManager.printCourseDetails(researchCourses);
    }
}

