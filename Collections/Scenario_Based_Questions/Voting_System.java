package GENERICS.Collections.Scenario_Based_Questions;

import java.util.*;

public class Voting_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> voteCount = new HashMap<>();
        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
        TreeMap<String, Integer> sortedVotes = new TreeMap<>();

        System.out.print("Enter number of votes to cast: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate name for vote #" + (i + 1) + ": ");
            String name = sc.nextLine();

            voteCount.put(name, voteCount.getOrDefault(name, 0) + 1);

            if (voteOrder.containsKey(name)) {
                voteOrder.put(name, voteOrder.get(name) + 1);
            } else {
                voteOrder.put(name, 1);
            }

            if (sortedVotes.containsKey(name)) {
                sortedVotes.put(name, sortedVotes.get(name) + 1);
            } else {
                sortedVotes.put(name, 1);
            }
        }

        System.out.println("\n🔹 Results from HashMap (Unordered):");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vote(s)");
        }

        System.out.println("\n🔹 Results from LinkedHashMap (Order of Voting):");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vote(s)");
        }

        System.out.println("\n🔹 Results from TreeMap (Sorted by Candidate):");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vote(s)");
        }

        sc.close();
    }
}

