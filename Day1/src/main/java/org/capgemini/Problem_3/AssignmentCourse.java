package org.capgemini.Problem_3;

// Subclass for Assignment-Based Courses
class AssignmentCourse extends CourseType {
    private int numberOfAssignments;

    public AssignmentCourse(String courseName, String department, int numberOfAssignments) {
        super(courseName, department);
        this.numberOfAssignments = numberOfAssignments;
    }

    public int getNumberOfAssignments() {
        return numberOfAssignments;
    }

    @Override
    public String toString() {
        return super.toString() + ", Number of Assignments: " + numberOfAssignments;
    }
}
