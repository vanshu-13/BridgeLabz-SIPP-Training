package GENERICS.JAVA_STREAMS;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> freqMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")) {
                    if (!word.isEmpty()) {
                        freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            freqMap.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .limit(5)
                    .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

