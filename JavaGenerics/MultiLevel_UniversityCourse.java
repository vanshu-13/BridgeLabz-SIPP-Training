package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    String courseName;
    CourseType(String courseName) { this.courseName = courseName; }
    public String toString() { return courseName; }
}

class ExamCourse extends CourseType {
    ExamCourse(String name) { super(name); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) { super(name); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) { super(name); }
}

class Course<T extends CourseType> {
    private T courseType;
    Course(T courseType) { this.courseType = courseType; }
    public void printCourseInfo() {
        System.out.println("Course: " + courseType);
    }

    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType ct : courses) {
            System.out.println(ct);
        }
    }
}

public class MultiLevel_UniversityCourse {
    public static void main(String[] args) {
        List<ExamCourse> examCourses = new ArrayList<>();
        examCourses.add(new ExamCourse("Data Structures"));
        examCourses.add(new ExamCourse("Algorithms"));

        List<AssignmentCourse> assignmentCourses = new ArrayList<>();
        assignmentCourses.add(new AssignmentCourse("Database Systems"));
        assignmentCourses.add(new AssignmentCourse("Operating Systems"));

        List<ResearchCourse> researchCourses = new ArrayList<>();
        researchCourses.add(new ResearchCourse("Machine Learning"));
        researchCourses.add(new ResearchCourse("Artificial Intelligence"));

        List<CourseType> allCourses = new ArrayList<>();
        allCourses.addAll(examCourses);
        allCourses.addAll(assignmentCourses);
        allCourses.addAll(researchCourses);

        System.out.println("Exam Courses:");
        Course.displayCourses(examCourses);

        System.out.println("\nAssignment Courses:");
        Course.displayCourses(assignmentCourses);

        System.out.println("\nResearch Courses:");
        Course.displayCourses(researchCourses);
        
        System.out.println("\nAll Courses:");
        Course.displayCourses(allCourses);
    }
}