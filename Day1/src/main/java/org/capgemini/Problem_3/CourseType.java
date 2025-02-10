package org.capgemini.Problem_3;

// Abstract base class representing a generic CourseType
 public abstract class CourseType {
    private String courseName;
    private String department;

    public CourseType(String courseName, String department) {
        this.courseName = courseName;
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", Department: " + department;
    }
}