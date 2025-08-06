package GENERICS.Collections.List_Interface;

import java.util.*;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        for (T item : list) seen.add(item);
        return new ArrayList<>(seen);
    }

    public static void main(String[] args) {
        List<Integer> withDuplicates = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> noDuplicates = removeDuplicates(withDuplicates);
        System.out.println("List without Duplicates: " + noDuplicates);
    }
}
