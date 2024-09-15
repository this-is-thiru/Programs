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
        if (amount >= coins[index]) {
            take = 1 + minCoins(index, coins, amount - coins[index], dp);
        }
        dp[index][amount] = Math.min(notTake, take);
        return dp[index][amount];
    }

    private static int minCoin1(int index, int[] coins, int amount, int[][] dp) {
        if (amount <= 0) {
            if (amount == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = index; i > -1; i--) {
            int include = minCoin1(i, coins, amount - coins[i], dp);
            if (include != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + include);
            }
        }
        dp[index][amount] = minCoins;
        return dp[index][amount];
    }


    public static void main(String[] args) {
        int[] coins = {4, 5};
        int amount = 6;
        int[][] minDP = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(minDP[i], -1);
        }
//        int minCoins = minCoins(coins.length - 1, coins, amount, minDP);
        int transformedCoins = minCoin1(coins.length - 1, coins, amount, minDP);
        int minCoins1 = transformedCoins == Integer.MAX_VALUE ? -1 : transformedCoins;
        System.out.println("minCoins: " + minCoins1 + ", minCoins1: " + minCoins1);
    }
}
