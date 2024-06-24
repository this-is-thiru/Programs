package coding_mafia;

import java.util.HashSet;
import java.util.Set;

public class KDiffPairs {

    private static int getDiffCount(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    set.add(Math.min(nums[i], nums[j]));
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5};
        int k = 2;

        int ans = getDiffCount(arr, k);
        System.out.println(ans);
    }
}
