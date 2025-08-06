package GENERICS.Collections.Set_Interface;

import java.util.*;

public class GetSymmetricDifference {
    public static <T> Set<T> getSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);

        Set<T> common = new HashSet<>(set1);
        common.retainAll(set2);

        result.removeAll(common);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Symmetric Difference: " + getSymmetricDifference(set1, set3));
    }
}
