package algos.neetcode.kadanes;

import java.util.Arrays;

public class SubArrayOfMaxSum {

    private static int[] subArrayOfMaxSum(int[] nums, int n) {

        int startIndex = 0;
        int maxLeft = 0;
        int maxRight = 0;

        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = nums[i];
                startIndex = i;
            }
            if (sum >= maxSum) {
                maxSum = sum;
                maxLeft = startIndex;
                maxRight = i;
            }
        }

        return new int[]{maxLeft, maxRight};
    }

    public static void main(String[] args) {
        int[] input = {-5, -4, 1, 8, -7, -9};

        int[] ans = subArrayOfMaxSum(input, input.length);
        System.out.println(Arrays.toString(ans));
    }
}
