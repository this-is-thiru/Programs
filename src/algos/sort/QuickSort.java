package algos.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }

        int pivot = arr[low];
        int yellow = low + 1;

        for (int i = yellow; i <= high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[yellow];
                arr[yellow] = temp;
                yellow++;
            }
        }

        int temp = arr[low];
        arr[low] = arr[yellow - 1];
        arr[yellow - 1] = temp;

        quickSort(arr, low, yellow - 1);
        quickSort(arr, yellow, high);
    }

    public static void main(String[] args) {

        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 4, 5, 6, 7, 8, 9, 10 };
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }
}
