package algos.fifty.arraysandhash;

import java.util.HashSet;
import java.util.Set;

public class LongConsecutiveArrayLength {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num: nums) {
            if (!set.contains(num-1)) {
                int length = 1;
                while (set.contains(num+length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input = {100, 1, 200, 4,2,3};
        int ans = longestConsecutive(input);
        System.out.println(ans);
    }
}
