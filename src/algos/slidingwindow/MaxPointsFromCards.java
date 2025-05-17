package algos.slidingwindow;

public class MaxPointsFromCards {
    private static int maxPoints(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;
        int i = k-1, j = nums.length - 1;

        while (i >= 0) {
            sum += (nums[j] - nums[i]);
            max = Math.max(max, sum);
            i--;
            j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k  = 4;
        int max = maxPoints(nums, k);
        System.out.println("Max points: " + max);
    }
}
