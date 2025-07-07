package com.bridgelaz;

import java.util.ArrayList;
import java.util.List;

// Employee class: Exists only within a Department
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Employee: " + name);
    }
}

// Department class: Composed inside a Company
class Department {
    private String name;
    private List<Employee> employees; // Composition - tightly bound to Department

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            e.show();
        }
    }
}

// Company class: Composed of Departments
class Company {
    private String name;
    private List<Department> departments; // Composition - Departments can't exist without Company

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showEmployees();
        }
    }
}

// Demonstration class
public class CompanyCompositionDemo {
    public static void main(String[] args) {
        Company tcs = new Company("TCS");

        Department devDept = new Department("Development");
        devDept.addEmployee("Ankit");
        devDept.addEmployee("Riya");

        Department hrDept = new Department("HR");
        hrDept.addEmployee("Sanya");

        tcs.addDepartment(devDept);
        tcs.addDepartment(hrDept);

        tcs.showStructure();

        // If tcs object is destroyed, departments and employees go with it — Composition
    }
}
