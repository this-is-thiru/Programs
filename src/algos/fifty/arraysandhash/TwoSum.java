package algos.fifty.arraysandhash;

import java.util.*;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,3,10};
        int[] ans = twoSum(nums, 9);
        System.out.println(Arrays.toString(ans));
    }
}
