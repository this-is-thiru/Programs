package sorts;

import java.util.Arrays;

public class QuickSort {
    private static void quickSort(int[] arr, int low, int high) {
        if (high <= low) {
            return;
        }

        int pivot = arr[low];
        int k = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k++;
            }
        }

        arr[k] = pivot;

        quickSort(arr, low, k - 1);
        quickSort(arr, k + 1, high);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 6, 8, 0, 3, 2, 5, 7, 24, 6, 8, 4, 7, 9, 345};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
