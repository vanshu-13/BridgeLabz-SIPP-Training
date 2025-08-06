package GENERICS.Collections.Queue_Interface;

import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int compareTo(Patient o) {
        return o.severity - this.severity; // higher severity first
    }

    public String toString() {
        return name + " (Severity " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Patient> pq = new PriorityQueue<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter severity: ");
            int sev = sc.nextInt(); sc.nextLine();
            pq.add(new Patient(name, sev));
        }

        System.out.println("Treatment order:");
        while (!pq.isEmpty()) System.out.println(pq.poll());
    }
}
