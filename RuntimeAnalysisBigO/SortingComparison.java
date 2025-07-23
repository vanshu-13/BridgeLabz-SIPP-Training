package runtimeAnalysis;
import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int size : datasetSizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10);
            }

            System.out.println("Dataset Size: " + size);

            if (size <= 10000) {
                int[] bubbleData = data.clone();
                long start = System.nanoTime();
                bubbleSort(bubbleData);
                long end = System.nanoTime();
                double timeMs = (end - start) / 1_000_000.0;
                System.out.printf("Bubble Sort: %.2f ms%n", timeMs);
            } else {
                System.out.println("Bubble Sort: Unfeasible for this size");
            }

            int[] mergeData = data.clone();
            long startMerge = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long endMerge = System.nanoTime();
            double mergeTimeMs = (endMerge - startMerge) / 1_000_000.0;
            System.out.printf("Merge Sort: %.2f ms%n", mergeTimeMs);

            int[] quickData = data.clone();
            long startQuick = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long endQuick = System.nanoTime();
            double quickTimeMs = (endQuick - startQuick) / 1_000_000.0;
            System.out.printf("Quick Sort: %.2f ms%n", quickTimeMs);

            System.out.println("---------------------------------------------------");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] Left = new int[n1];
        int[] Right = new int[n2];

        System.arraycopy(arr, left, Left, 0, n1);
        System.arraycopy(arr, mid + 1, Right, 0, n2);

        int i=0, j=0, k=left;
        while (i<n1 && j<n2) {
            if (Left[i] <= Right[j]) {
                arr[k++] = Left[i++];
            } else {
                arr[k++] = Right[j++];
            }
        }
        while (i<n1) {
            arr[k++] = Left[i++];
        }
        while (j<n2) {
            arr[k++] = Right[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low -1;
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}