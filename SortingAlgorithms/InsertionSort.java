public class InsertionSort {
    public static void insertionSort(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] ids = {102, 56, 213, 78, 43, 198};
        insertionSort(ids);
        System.out.println("Sorted Employee IDs:");
        for (int id : ids) {
            System.out.print(id + " ");
        }
    }
}

