package runtimeAnalysis;
import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        int target = -1;
        Random rand = new Random();

        for (int size : datasetSizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size*10);
            }

            target = data[rand.nextInt(size)];

            System.out.println("Dataset Size: " + size);
            System.out.println("Target value: " + target);

            long startTime = System.nanoTime();
            boolean linearFound = linearSearch(data, target);
            long endTime = System.nanoTime();
            double linearTimeMs = (endTime - startTime) / 1_000_000.0;

            int[] sortedData = data.clone();
            Arrays.sort(sortedData);
            startTime = System.nanoTime();
            boolean binaryFound = binarySearch(sortedData, target);
            endTime = System.nanoTime();
            double binaryTimeMs = (endTime - startTime) / 1_000_000.0;

            System.out.printf("Linear Search: %.6f ms, Found: %b%n", linearTimeMs, linearFound);
            System.out.printf("Binary Search: %.6f ms, Found: %b%n", binaryTimeMs, binaryFound);
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

    public static boolean binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return true;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}