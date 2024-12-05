package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            if (min_idx != i) {
                QuickSort.swap(arr, i, min_idx);
            }
        }
        return arr;
    }
    // time = O(n^2) & space = O(1)
    public static void main(String[] args) {
        int[] arr = {-1, -2, 0, 3, 2, 1};
        int[] arrNew = selectionSort(arr);
        System.out.println(Arrays.toString(arrNew));
    }
}
