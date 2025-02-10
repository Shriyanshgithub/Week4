package org.capgemini.Problem_3;

// Subclass for Research-Based Courses
class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String courseName, String department, String researchTopic) {
        super(courseName, department);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    @Override
    public String toString() {
        return super.toString() + ", Research Topic: " + researchTopic;
    }
}
