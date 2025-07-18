package LinearBinarySearch;


public class ExamHallSeatChecker {

    public static void main(String[] args) {
        int[][] halls = {
            {10, 20, 30, 40, 50},
            {15, 25, 35, 45, 55},
            {5, 12, 18, 25, 33}
        };

        int seatToFind = 26;
        
        checkSeatAvailability(halls, seatToFind);
    }

    public static void checkSeatAvailability(int[][] halls, int seat) {
        boolean seatFound = false;

        for (int i = 0; i < halls.length; i++) {
            int[] hall = halls[i];
            int resultIndex = binarySearch(hall, seat);

            if (resultIndex != -1) {
                System.out.println("Seat " + seat + " found in Hall " + (i + 1) + ", Position " + (resultIndex + 1));
                seatFound = true;
                break;
            } else {
                int nearestSeatIndex = findNearestSeat(hall, seat);
                if (nearestSeatIndex != -1) {
                    System.out.println("Seat " + seat + " not found in Hall " + (i + 1) + ". Nearest available seat: " + hall[nearestSeatIndex] + " in Position " + (nearestSeatIndex + 1));
                }
            }
        }

        if (!seatFound) {
            System.out.println("Seat " + seat + " is not available in any hall.");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static int findNearestSeat(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int left = 0, right = arr.length - 1;
        int nearestIdx = -1;
        int minDiff = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int diff = Math.abs(arr[mid] - target);

            if (diff < minDiff) {
                minDiff = diff;
                nearestIdx = mid;
            }

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nearestIdx;
    }
}