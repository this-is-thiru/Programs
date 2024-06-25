package coding_mafia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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

    private static int optimalGetDiffCount(int[] nums, int k) {

        int count = 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            int diff = Math.abs(nums[i] - nums[j]);
            if (diff > k) {
                while (diff > k) {
                    diff = Math.abs(nums[i] - nums[j]);
                    i++;
                }
                i--;
                if (diff == k) {
                    count++;
                }
            } else if (diff < k) {
                continue;
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 1, 4, 1, 5};
        int[] arr = {3, 1, 4, 1, 1, 1, 5, 6, 6, 6, 2};
        List<Integer> lst = Arrays.stream(arr).boxed().toList();
        Set<Integer> set = new HashSet<>(lst);
        int k = 4;

        int ans = getDiffCount(arr, k);
        System.out.println("Normal: " + ans);

        lst = new ArrayList<>(set);
        Collections.sort(lst);
        int[] transformedArray = lst.stream().mapToInt(Integer::intValue).toArray();
        ans = optimalGetDiffCount(transformedArray, k);
        System.out.println("Optimal: " + ans);
    }
}
