package algos.sort;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int count = 0;
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[count] = arr[i];
                i++;
            } else {
                temp[count] = arr[j];
                j++;
            }
            count++;
        }
        while (i <= mid) {
            temp[count] = arr[i];
            i++;
            count++;
        }
        while (j <= high) {
            temp[count] = arr[j];
            j++;
            count++;
        }
        for (int k = low; k <= high; k++) {
            arr[k] = temp[k - low];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 4, 5, 6, 7, 8, 9, 10};
        int low = 0;
        int high = arr.length - 1;
        mergeSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }
}
