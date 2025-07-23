package runtimeAnalysis;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        Random rand = new Random();

        for (int size : datasetSizes) {
            int[] dataArray = new int[size];
            for (int i = 0; i < size; i++) {
                dataArray[i] = rand.nextInt(size * 10);
            }

            int targetIndex = rand.nextInt(size);
            int target = dataArray[targetIndex];

            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int num : dataArray) {
                hashSet.add(num);
                treeSet.add(num);
            }

            System.out.println("Dataset Size: " + size);
            System.out.println("Searching for: " + target);

            long startArray = System.nanoTime();
            boolean foundArray = linearSearch(dataArray, target);
            long endArray = System.nanoTime();
            double timeArrayMs = (endArray - startArray) / 1_000_000.0;
            System.out.printf("Array Search (Linear): %.3f ms, Found: %b%n", timeArrayMs, foundArray);

            long startHashSet = System.nanoTime();
            boolean foundHashSet = hashSet.contains(target);
            long endHashSet = System.nanoTime();
            double timeHashSetMs = (endHashSet - startHashSet) / 1_000_000.0;
            System.out.printf("HashSet Search: %.3f ms, Found: %b%n", timeHashSetMs, foundHashSet);

            long startTreeSet = System.nanoTime();
            boolean foundTreeSet = treeSet.contains(target);
            long endTreeSet = System.nanoTime();
            double timeTreeSetMs = (endTreeSet - startTreeSet) / 1_000_000.0;
            System.out.printf("TreeSet Search: %.3f ms, Found: %b%n", timeTreeSetMs, foundTreeSet);

            System.out.println("---------------------------------------------------");
        }
    }

    public static boolean linearSearch(int[] data, int target) {
        for (int num : data) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}