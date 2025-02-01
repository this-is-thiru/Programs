package sorts;

import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] arr, int left, int mid, int right) {
        int length = right - left + 1;
        int[] temp = new int[length];

        int i = left, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        k = 0;
        for (int l = left; l <= right; l++) {
            arr[l] = temp[k];
            k++;
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 6, 8, 0, 3, 2, 5, 7, 24, 6, 8, 4, 7, 9, 345};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
