package org.capgemini.Problem_3;

// Subclass for Exam-Based Courses
class ExamCourse extends CourseType {
    private int examWeightage;

    public ExamCourse(String courseName, String department, int examWeightage) {
        super(courseName, department);
        this.examWeightage = examWeightage;
    }

    public int getExamWeightage() {
        return examWeightage;
    }

    @Override
    public String toString() {
        return super.toString() + ", Exam Weightage: " + examWeightage + "%";
    }
}
