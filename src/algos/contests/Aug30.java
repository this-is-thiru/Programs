package algos.contests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Aug30 {

    private static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        System.out.println(pq);

        int i = 0;
        while (i < k) {
            int[] poll = pq.poll();
            poll[0] = poll[0] * multiplier;
            pq.offer(poll);
            i++;
        }

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            nums[temp[1]] = temp[0];
        }

        return nums;

    }

    public static void main(String[] args) {
        int[] input = {2, 1, 3, 5, 6};
        int k = 5, multiplier = 2;

        int[] ans = getFinalState(input, k, multiplier);
        System.out.println(Arrays.toString(ans));

    }
}
