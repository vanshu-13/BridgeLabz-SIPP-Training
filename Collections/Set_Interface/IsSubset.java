package GENERICS.Collections.Set_Interface;

import java.util.*;

public class IsSubset {
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> subset = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> fullSet = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Is subset? " + isSubset(subset, fullSet));
    }
}
