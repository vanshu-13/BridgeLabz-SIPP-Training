package GENERICS.Collections.Map_Interface;

import java.util.*;

public class MapInverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> inputMap = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Key: ");
            String key = sc.nextLine();
            System.out.print("Value: ");
            int value = sc.nextInt(); sc.nextLine();
            inputMap.put(key, value);
        }

        Map<Integer, List<String>> inverted = new HashMap<>();
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("Inverted Map: " + inverted);
    }
}
