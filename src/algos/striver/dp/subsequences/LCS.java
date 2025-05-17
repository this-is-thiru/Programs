package algos.striver.dp.subsequences;

import java.util.Arrays;

public class LCS {
    private static int longestCommonSubsequence(String s1, String s2, int i, int i1, int[][] dp) {
        if (i < 0 || i1 < 0) {
            return 0;
        }

        if (dp[i][i1] != -1) {
            return dp[i][i1];
        }
        if (s1.charAt(i) == s2.charAt(i1)) {
            return dp[i][i1] = 1 + longestCommonSubsequence(s1, s2, i - 1, i1 - 1, dp);
        }
        return dp[i][i1] = Math.max(longestCommonSubsequence(s1, s2, i - 1, i1, dp), longestCommonSubsequence(s1, s2, i, i1 - 1, dp));
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Length of LCS: " + longestCommonSubsequence(s1, s2, s1.length() - 1, s2.length() - 1, dp));
    }
}
