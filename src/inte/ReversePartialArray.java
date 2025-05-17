package inte;

import java.util.Arrays;

public class ReversePartialArray {
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2};
        reverse(arr, 1, 4);
        System.out.println(Arrays.toString(arr));
    }
}
