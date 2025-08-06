package GENERICS.Collections.Set_Interface;

import java.util.*;

public class ConvertSetToSortedList {
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }
    public static void main(String[] args) {
        Set<Integer> unsorted = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Sorted List: " + convertSetToSortedList(unsorted));
    }
}
