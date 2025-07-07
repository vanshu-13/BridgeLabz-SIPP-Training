package com.bridgelaz;

import java.util.*;

// Faculty class: can exist independently (aggregation)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Faculty: " + name);
    }
}

// Department class: composed inside University
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Department: " + name);
    }
}

// University class: composition with Department, aggregation with Faculty
class University {
    private String name;
    private List<Department> departments = new ArrayList<>();
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void showStructure() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.show();
        }
        for (Faculty f : faculties) {
            f.show();
        }
    }

    public void deleteUniversity() {
        departments.clear(); // all departments removed with university (composition)
        System.out.println("University deleted. Departments removed.");
    }
}

// Demo class
public class UniversityDemo {
    public static void main(String[] args) {
        University uni = new University("IIT Delhi");
        Department cs = new Department("Computer Science");
        Department ee = new Department("Electrical");

        Faculty f1 = new Faculty("Dr. Mehta");
        Faculty f2 = new Faculty("Prof. Kaur");

        uni.addDepartment(cs);
        uni.addDepartment(ee);
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showStructure();

        // Delete university
        uni.deleteUniversity();
    }
}
