package algos.contests.powerprogrammer.dec24;

import java.util.PriorityQueue;

public class HandsOn {
    static class Pair {
        int num;
        int index;
        Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
    private static boolean isPrime(int num) {
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static int getMaxNumber(int[] nums, int[] bools, int n) {
        for (int i = 0; i < n; i++) {
            if (!isPrime(nums[i])) {
                nums[i] = 0;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.num - a.num);
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
            if (bools[i] == 1) {
                Pair pair = pq.poll();
                bools[i] = 0;
                bools[pair.index] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (bools[i] == 1) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,3,6,5};
//        int[] bools = {1,0,1,0,0};
        int[] nums = {5, 1, 2, 1, 13};
        int[] bools = {0, 0, 1, 0, 0};

        int ans = getMaxNumber(nums, bools, nums.length);
        System.out.println(ans);
    }
}
