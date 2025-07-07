import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEmployeeManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Sample input for demonstration
        System.out.println("Enter number of employees:");
        int n = s.nextInt();
        s.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter employee type (1 for FullTime, 2 for PartTime):");
            int type = s.nextInt();
            s.nextLine(); // consume newline

            System.out.println("Enter employee ID:");
            int id = s.nextInt();
            s.nextLine();

            System.out.println("Enter employee name:");
            String name = s.nextLine();

            System.out.println("Enter base salary:");
            double baseSalary = s.nextDouble();
            s.nextLine();

            if (type == 1) {
                System.out.println("Enter fixed salary:");
                double fixedSalary = s.nextDouble();
                s.nextLine();

                FullTimeEmployee fte = new FullTimeEmployee(id, name, baseSalary, fixedSalary);
                System.out.println("Enter department:");
                String dept = s.nextLine();
                fte.assignDepartment(dept);
                employees.add(fte);
            } else if (type == 2) {
                System.out.println("Enter work hours:");
                int workHours = s.nextInt();
                s.nextLine();

                System.out.println("Enter hourly rate:");
                double hourlyRate = s.nextDouble();
                s.nextLine();

                PartTimeEmployee pte = new PartTimeEmployee(id, name, baseSalary, workHours, hourlyRate);
                System.out.println("Enter department:");
                String dept = s.nextLine();
                pte.assignDepartment(dept);
                employees.add(pte);
            } else {
                System.out.println("Invalid employee type.");
                i--;
            }
        }

        System.out.println("\nEmployee Details:");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
