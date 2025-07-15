public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[minIdx];
            scores[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {88, 92, 74, 63, 99, 81};
        selectionSort(scores);
        System.out.println("Sorted Exam Scores:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
