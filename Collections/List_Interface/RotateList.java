package GENERICS.Collections.List_Interface;

import java.util.*;

public class RotateList {
    public static <T> void rotateList(List<T> list, int k) {
        int size = list.size();
        k = k % size;
        List<T> rotated = new ArrayList<>();
        for (int i = k; i < size; i++) rotated.add(list.get(i));
        for (int i = 0; i < k; i++) rotated.add(list.get(i));
        for (int i = 0; i < size; i++) list.set(i, rotated.get(i));
    }

    public static void main(String[] args) {
        List<Integer> rotateList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateList(rotateList, 2);
        System.out.println("Rotated List: " + rotateList);
    }
}
