package algos.neetcode;

import java.util.Arrays;

public class CoinsChange {
    private static int minCoins(int index, int[] coins, int amount, int[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return (int) 1e9;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notTake = minCoins(index - 1, coins, amount, dp);
        int take = (int) 1e9;
        if (amount>=coins[index]) {
            take = 1 + minCoins(index, coins, amount - coins[index], dp);
        }
        dp[index][amount] = Math.min(notTake, take);
        return dp[index][amount];
    }

    private static int maxCoins(int index, int[] coins, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return -1;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notTake = maxCoins(index - 1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if (amount>=coins[index]) {
            take = 1 + maxCoins(index, coins, amount - coins[index], dp);
        }
        dp[index][amount] = Math.max(notTake, take);
        return dp[index][amount];
    }

    public static void main(String[] args) {
        int[] coins = {2,5,10};
        int amount = 3;
        int[][] minDP = new int[coins.length][amount+1];
        int[][] maxDP = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(minDP[i], -1);
            Arrays.fill(maxDP[i], -1);
        }
        int minCoins = minCoins(coins.length - 1, coins, amount, minDP);
        int maxCoins = maxCoins(coins.length - 1, coins, amount, maxDP);
        System.out.println("minCoins: " + minCoins+", maxCoins: " + maxCoins);
    }
}
