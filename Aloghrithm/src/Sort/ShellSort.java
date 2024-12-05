package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int x = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > x; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = x;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        System.out.println("Array before sorting");
        System.out.println(Arrays.toString(arr));

        shellSort(arr, arr.length);

        System.out.println("Array after sorting");
        System.out.println(Arrays.toString(arr));
    }

}
