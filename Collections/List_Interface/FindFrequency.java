package GENERICS.Collections.List_Interface;

import java.util.*;
public class FindFrequency {
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> freqMap = findFrequency(words);
        System.out.println("Frequency Map: " + freqMap);
    }
}
