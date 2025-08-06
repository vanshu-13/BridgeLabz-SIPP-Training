package GENERICS.Collections.Map_Interface;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine().toLowerCase().replaceAll("[^a-z ]", "");

        Map<String, Integer> map = new HashMap<>();
        for (String word : input.split("\\s+")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies: " + map);
    }
}
