package GENERICS.Collections.Scenario_Based_Questions;

import java.util.*;
import java.text.*;

class PolicyMap {
    String number, holder, type;
    Date expiry;
    double premium;

    public PolicyMap(String number, String holder, Date expiry, String type, double premium) {
        this.number = number;
        this.holder = holder;
        this.expiry = expiry;
        this.type = type;
        this.premium = premium;
    }

    public String toString() {
        return number + " | " + holder + " | " + expiry + " | " + type + " | " + premium;
    }
}

public class Insurance_Policy_Management_System_Using_Map {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Map<String, PolicyMap> hashMap = new HashMap<>();
        Map<String, PolicyMap> linkedMap = new LinkedHashMap<>();
        TreeMap<Date, List<PolicyMap>> treeMap = new TreeMap<>();

        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();
        sc.nextLine();

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

            PolicyMap p = new PolicyMap(num, name, date, type, premium);

            hashMap.put(num, p);
            linkedMap.put(num, p);

            treeMap.computeIfAbsent(date, k -> new ArrayList<>()).add(p);
        }

        System.out.print("\nEnter policy number to retrieve: ");
        String search = sc.nextLine();
        System.out.println(hashMap.getOrDefault(search, null));

        System.out.println("\n=== Policies Expiring Within 30 Days:");
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date limit = cal.getTime();

        for (Map.Entry<Date, List<PolicyMap>> entry : treeMap.entrySet()) {
            if (!entry.getKey().before(now) && !entry.getKey().after(limit)) {
                for (PolicyMap p : entry.getValue()) {
                    System.out.println(p);
                }
            }
        }

        System.out.print("\nEnter policyholder name to search: ");
        String holder = sc.nextLine();
        for (PolicyMap p : hashMap.values()) {
            if (p.holder.equalsIgnoreCase(holder)) {
                System.out.println(p);
            }
        }

        System.out.println("\n=== Removing expired policies...");
        Iterator<Map.Entry<String, PolicyMap>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            PolicyMap p = it.next().getValue();
            if (p.expiry.before(now)) {
                it.remove();
            }
        }

        System.out.println("Remaining policies after removal:");
        hashMap.values().forEach(System.out::println);
    }
}
