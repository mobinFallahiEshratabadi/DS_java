package Sort;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        int x;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = x;
        }
        return arr;
    }

    // time = O(n^2) & space = O(1)
}
