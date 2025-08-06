package GENERICS.Collections.Map_Interface;

import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Key: ");
            String key = sc.nextLine();
            System.out.print("Value: ");
            int value = sc.nextInt(); sc.nextLine();
            map.put(key, value);
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        System.out.println("Key with highest value: " + maxKey);
    }
}
