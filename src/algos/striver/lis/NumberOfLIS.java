package algos.striver.lis;

public class NumberOfLIS {
    private static int numberOfLIS(int[] nums, int n) {
        int[] dp = new int[n];
        int[] counts = new int[n];


        for (int index = 0; index < n; index++) {
            counts[index] = 1;
            for (int pre_index = 0; pre_index < index; pre_index++) {
                if (nums[index] > nums[pre_index]) {
                    if (dp[index] == dp[pre_index] + 1) {
                        counts[index] += counts[pre_index];
                    } else if (dp[index] < dp[pre_index] + 1) {
                        dp[index] = dp[pre_index] + 1;
                        counts[index] = counts[pre_index];
                    }
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                totalCount += counts[i];
            }
        }

        return totalCount;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2};
        int n = nums.length;

        int tabulationAnsBest = numberOfLIS(nums, n);
        System.out.println("Total number of LIS: " + tabulationAnsBest);
    }
}
