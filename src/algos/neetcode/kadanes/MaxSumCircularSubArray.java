package algos.neetcode.kadanes;

public class MaxSumCircularSubArray {

    private static int maxSumCircularSubArray(int[] nums, int n) {
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int a : nums) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {

        int[] input = {1,-2,3,-2};

        int ans = maxSumCircularSubArray(input, input.length);
        System.out.println(ans);
    }
}
