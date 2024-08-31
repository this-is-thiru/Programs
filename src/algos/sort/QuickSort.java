package algos.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (high <= low) {
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
        yellow--;
        int temp = arr[low];
        arr[low] = arr[yellow];
        arr[yellow] = temp;

        quickSort(arr, low, yellow-1);
        quickSort(arr, yellow + 1, high);
    }

    public static void main(String[] args) {

        int[] arr = {110, 100, 0};
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }
}
