package LinearBinarySearch;

import java.util.*;

public class GameHighScoreFinder {

    public static int findScoreRank(List<Integer> scores, int score) {
        int low = 0;
        int high = scores.size() - 1;
        int mid;
        
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (scores.get(mid) == score) {
                return mid + 1;
            } else if (scores.get(mid) < score) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low + 1;
    }

    private static boolean scoreBeats(List<Integer> scores, int score) {
        if (scores.size() < 100) {
            return true;
        }
        return score > scores.get(99);
    }

    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(Arrays.asList(
            9500, 9300, 9200, 9100, 8900,
            8700, 8600, 8500, 8400, 8300,
            8200, 8100, 8000, 7900, 7800,
            7700, 7600, 7500, 7400, 7300,
            7200, 7100, 7000, 6900, 6800,
            6700, 6600, 6500, 6400, 6300,
            6200, 6100, 6000, 5900, 5800,
            5700, 5600, 5500, 5400, 5300,
            5200, 5100, 5000, 4900, 4800,
            4700, 4600, 4500, 4400, 4300,
            1000, 900, 800, 700, 600
        ));

        int[] testScores = {8500, 9500, 500, 100, 95000};

        for (int testScore : testScores) {
            int rank = findScoreRank(scores, testScore);

            if (rank <= 100 && (rank - 1) < scores.size()) {
                if (scores.get(rank - 1) == testScore) {
                    System.out.println("Score " + testScore + " is in the top 100 at position: " + rank);
                } else {
                    System.out.println("Score " + testScore + " would be in the top 100 at position: " + rank);
                }
            } else {
                if (scoreBeats(scores, testScore)) {
                    int indexToCompare = Math.min(99, scores.size() - 1);
                    int pointsNeeded = scores.get(indexToCompare) - testScore + 1;
                    System.out.println("Score " + testScore + " is not in top 100. Need " + pointsNeeded + " more points to enter the top 100.");
                } else {
                    System.out.println("Score " + testScore + " is too low to enter the top 100.");
                }
            }
        }
    }
}