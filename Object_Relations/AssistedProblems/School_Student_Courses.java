package com.bridgelaz;

import java.util.*;

// Course class: shared by many students (association)
class Course {
    private String courseName;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public String getName() {
        return courseName;
    }

    public void showStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }
}

// Student class: associated with multiple courses
class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this); // two-way association
    }

    public void viewCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.getName());
        }
    }

    public String getName() {
        return name;
    }
}

// School class: aggregates students
class School {
    private String schoolName;
    private List<Student> students = new ArrayList<>();

    public School(String name) {
        this.schoolName = name;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void listStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

// Demo class
public class SchoolDemo {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        Student a = new Student("Anya");
        Student b = new Student("Ravi");

        school.addStudent(a);
        school.addStudent(b);

        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");

        a.enrollInCourse(math);
        a.enrollInCourse(physics);
        b.enrollInCourse(math);

        a.viewCourses();
        b.viewCourses();
        math.showStudents();
        physics.showStudents();
    }
}
