package challengeProblem;

import java.util.Arrays;

public class FirstMissingPositive {

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {3, 4, -1, 1, 2, 7, 8, 9};
        int target = 7;

        int[] listForMissing = Arrays.copyOf(list, list.length);
        int[] listForSorting = Arrays.copyOf(list, list.length);

        int missingPositive = findFirstMissingPositive(listForMissing);
        System.out.println("First missing positive: " + missingPositive);

        Arrays.sort(listForSorting);
        int index = binarySearch(listForSorting, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at sorted index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}