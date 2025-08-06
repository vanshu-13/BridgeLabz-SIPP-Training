package GENERICS.Collections.Map_Interface;

import java.util.*;

class Employee {
    String name, department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class EmployeeGrouping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Employee>> deptMap = new HashMap<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();

            deptMap.computeIfAbsent(dept, d -> new ArrayList<>()).add(new Employee(name, dept));
        }

        System.out.println("Grouped by Department:");
        for (Map.Entry<String, List<Employee>> e : deptMap.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
