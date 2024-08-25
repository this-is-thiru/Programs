package algos.neetcode.kadanes;

public class MaxSumOfSubArray {

    private static int maxSumCircularSubArray(int[] nums, int n) {
        int maxSum = nums[0], curMax = 0;
        for (int a : nums) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] input = {3, -2, 3, -2};

        int ans = maxSumCircularSubArray(input, input.length);
        System.out.println(ans);
    }
}
