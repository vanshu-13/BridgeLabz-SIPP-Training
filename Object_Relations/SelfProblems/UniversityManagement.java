package com.bridgelaz;

import java.util.*;

// Course class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println("Professor " + p.getName() + " assigned to " + courseName);
    }

    public void enrollStudent(Student s) {
        enrolledStudents.add(s);
        System.out.println(s.getName() + " enrolled in " + courseName);
    }

    public String getCourseName() {
        return courseName;
    }
}

// Professor class
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Student class
class Student {
    private String name;
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course c) {
        enrolledCourses.add(c);
        c.enrollStudent(this);
    }

    public String getName() {
        return name;
    }
}

// Demo class
public class UniversitySystemDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Ishaan");
        Student s2 = new Student("Meera");

        Professor prof = new Professor("Dr. Kapoor");

        Course java = new Course("Java Programming");
        java.assignProfessor(prof);

        s1.enrollCourse(java);
        s2.enrollCourse(java);
    }
}
