package binarySearch;

public class FirstAndLastOccurrence {
    
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 4, 4, 4, 5, 6, 8, 8, 9};
        int target = 4;

        int firstIndex = findFirstOccurrence(sortedArray, target);
        int lastIndex = findLastOccurrence(sortedArray, target);

        if (firstIndex != -1 && lastIndex != -1) {
            System.out.println("First occurrence of " + target + ": " + firstIndex);
            System.out.println("Last occurrence of " + target + ": " + lastIndex);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}