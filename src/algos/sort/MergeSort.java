package algos.sort;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
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
        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < temp.length; l++) {
            arr[l + low] = temp[l];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {

        if (high == low) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {

        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 4, 5, 6, 7, 8, 9, 10 };
        int low = 0;
        int high = arr.length - 1;
        mergeSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }
}
