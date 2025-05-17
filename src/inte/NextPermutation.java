package inte;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {3,2,1};
        int[] nums = {1, 2, 3, 4, 5, 7, 6};
        nextPermutation(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums, int n) {
        int thresholdNumindex = -1;
        for (int i=n-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                thresholdNumindex = i;
                break;
            }
        }

        if (thresholdNumindex == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        for (int i=n-1; i>=0; i--) {
            if (nums[i] > nums[thresholdNumindex]) {
                int temp = nums[thresholdNumindex];
                nums[thresholdNumindex] =  nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums, thresholdNumindex+1, n-1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
