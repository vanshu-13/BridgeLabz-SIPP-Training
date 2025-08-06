package GENERICS.Collections.Scenario_Based_Questions;

import java.util.*;
import java.text.*;

class Policy implements Comparable<Policy> {
    String number, holder, type;
    Date expiry;
    double premium;

    public Policy(String number, String holder, Date expiry, String type, double premium) {
        this.number = number;
        this.holder = holder;
        this.expiry = expiry;
        this.type = type;
        this.premium = premium;
    }

    @Override
    public String toString() {
        return number + " | " + holder + " | " + expiry + " | " + type + " | " + premium;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Policy) {
            return this.number.equals(((Policy)o).number);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public int compareTo(Policy p) {
        return this.expiry.compareTo(p.expiry);
    }
}

public class Insurance_Policy_Management_System_Using_Set {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> duplicateChecker = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Policy #" + (i + 1));
            System.out.print("Policy Number: ");
            String num = sc.nextLine();
            System.out.print("Policyholder Name: ");
            String name = sc.nextLine();
            System.out.print("Expiry Date (yyyy-MM-dd): ");
            Date date = sdf.parse(sc.nextLine());
            System.out.print("Coverage Type: ");
            String type = sc.nextLine();
            System.out.print("Premium: ");
            double premium = sc.nextDouble();
            sc.nextLine();

            Policy p = new Policy(num, name, date, type, premium);

            hashSet.add(p);
            linkedSet.add(p);
            treeSet.add(p);

            duplicateChecker.put(num, duplicateChecker.getOrDefault(num, 0) + 1);
        }

        System.out.println("\n=== All Unique Policies (HashSet):");
        hashSet.forEach(System.out::println);

        System.out.println("\n=== Policies in Insertion Order (LinkedHashSet):");
        linkedSet.forEach(System.out::println);

        System.out.println("\n=== Policies Sorted by Expiry (TreeSet):");
        treeSet.forEach(System.out::println);

        System.out.println("\n=== Policies Expiring Within 30 Days:");
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date future = cal.getTime();
        treeSet.stream().filter(p -> !p.expiry.before(now) && !p.expiry.after(future)).forEach(System.out::println);
        System.out.print("\nEnter coverage type to filter: ");
        String filterType = sc.nextLine();
        treeSet.stream().filter(p -> p.type.equalsIgnoreCase(filterType)).forEach(System.out::println);

        System.out.println("\n=== Duplicate Policies (By Policy Number):");
        duplicateChecker.entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> System.out.println("Policy #" + e.getKey() + " is duplicated."));
    }
}

