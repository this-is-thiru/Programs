package algos.dp;

public class NinjaScoreMax {
    private static int maxScore(int day, int chosenActivity, int[][] scores, int[][] dp, int n, int m) {
        if (day >= n) {
            return 0;
        }

        int currentMax = Integer.MIN_VALUE;
        int[] currentScores = scores[day];
        for (int i = 0; i < m; i++) {
            if (i == chosenActivity) {
                continue;
            }

            int score = currentScores[i] + maxScore(day + 1, i, scores, dp, n, m);
            currentMax = Math.max(currentMax, score);
            dp[day][i] = currentMax;
        }
        return currentMax;
    }

    public static void main(String[] args) {
        int[][] input = input();
        int n = input.length;
        int m = input[0].length;
        int[][] dp = dp(n, m);
        int maxScore = maxScore(0, -1, input, dp, n, m);
        System.out.println("Max score: " + maxScore);
    }

    private static int[][] input() {
        return new int[][]{{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
//        return new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
    }

    private static int[][] dp(int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[m];
        }
        return dp;
    }
}
