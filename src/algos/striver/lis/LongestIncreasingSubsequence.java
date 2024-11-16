package algos.striver.lis;

public class LongestIncreasingSubsequence {
    private static int lengthOfLISMemoization(int index, int prevIndex, int[] nums, int n, int[][] dp) {
        if (index == n) return 0;
        if (dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        int len = lengthOfLISMemoization(index + 1, prevIndex, nums, n, dp); // not pick case
        if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
            len = Math.max(len, 1 + lengthOfLISMemoization(index + 1, index, nums, n, dp));
        }
        return dp[index][prevIndex + 1] = len;
    }

    private static int lengthOfLISTabulation(int[] nums, int n) {
        int[] nextRow = new int[n + 1];
        int[] curRow = new int[n + 1];

        for (int i = n - 1; i > -1; i--) {
            for (int prev_ind = i - 1; prev_ind >= -1; prev_ind--) {
                int len = nextRow[prev_ind + 1];
                if (prev_ind == -1 || nums[prev_ind] < nums[i]) {
                    len = Math.max(len, 1 + nextRow[i + 1]);
                }

                curRow[prev_ind + 1] = len;
            }
            nextRow = curRow;
        }
        return curRow[-1 + 1];
    }

    private static int lengthOfLISTabulationBestIntuition(int[] nums, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 0, 4, 4};
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int lis = lengthOfLISMemoization(0, -1, nums, n, dp);
        System.out.println("Memoisation Ans: " + lis);
        int tabulationAns = lengthOfLISTabulation(nums, n);
        System.out.println("Tabulation Ans: " + tabulationAns);
        int tabulationAnsBest = lengthOfLISTabulationBestIntuition(nums, n);
        System.out.println("Tabulation Best Ans: " + tabulationAnsBest);
    }
}
