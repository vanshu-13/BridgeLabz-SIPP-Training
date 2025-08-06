package GENERICS.Collections.Set_Interface;

import java.util.*;

public class GetIntersection {
    public static <T> Set<T> getUnion(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public static <T> Set<T> getIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Union: " + getUnion(set1, set3));
        System.out.println("Intersection: " + getIntersection(set1, set3));
    }
}
