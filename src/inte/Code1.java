package inte;

import java.util.Arrays;

public class Code1 {
    private static boolean isBetween(int[] int1, int[] int2) {
        // {2,3} {3,4}, {8,9}
        // {2,8}
        if (int1[1] < int2[0] || int1[0] > int2[1]) return false;
        return true;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length + 1][2];
        int index = 0;
        int firstIndex = -1;

        for (int i = 0; i < intervals.length; i++) {
            if (isBetween(intervals[i], newInterval)) {
                ans[index] = intervals[i];

                if (firstIndex == -1) {
                    firstIndex = i;
                }

                index++;
            }
        }

        int min = Math.min(newInterval[0], ans[0][0]);
        int max = Math.max(newInterval[1], ans[index - 1][1]);
        int[] newInt = {min, max};

        int[][] res = new int[intervals.length + 1][2];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i < firstIndex) {
                res[count] = intervals[i];
                count++;
            } else if (i == firstIndex) {
                res[count] = newInt;
                count++;
            } else if (i > index + firstIndex - 1) {
                res[count] = intervals[i];
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 1}, {1, 2}, {3, 6}, {8, 10}, {15, 18}};
        int[] newInterval = {3, 8};
        int[][] ans = insert(intervals, newInterval);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
