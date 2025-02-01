package algos.striver.dp.subsequences;

import java.util.Arrays;

public class FrogJumps {
    private static int frogJumps(int index, int k, int[] stones) {
        if (index == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int kmin = Math.abs(stones[index] - stones[index - i]) + frogJumps(index - i, k, stones);
                min = Math.min(min, kmin);
            }
        }

        return min;
    }

    private static int frogJumps(int index, int[] stones) {
        if (index == 0) {
            return 0;
        }

        int fj = Math.abs(stones[index] - stones[index - 1]) + frogJumps(index - 1, stones);

        int sj = Integer.MAX_VALUE;
        if (index - 1 > 0) {
            sj = Math.min(sj, Math.abs(stones[index] - stones[index - 2]) + frogJumps(index - 2, stones));
        }

        return Math.min(fj, sj);
    }

    public static void main(String[] args) {
        int[] distances = {10, 30, 40, 50, 20};
        int k = 3;

        int ans = frogJumps(distances.length - 1, k, distances);
        System.out.println("Answer: " + ans);
    }
}
