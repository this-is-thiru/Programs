package algos.fifty.arraysandhash;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int diff = nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int diff1 = -(diff + nums[j]);
                if (set.contains(diff1)) {
                    List<Integer> list = Arrays.asList(diff, nums[j], diff1);
                    ans.add(list);
                }
                set.add(nums[j]);
            }
        }

        return ans;
    }

    public static List<List<Integer>> threeSumOpt(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n-1 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;

                } else if (sum > 0) {
                    k--;

                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while (nums[j] == nums[j-1]) j++;
                    while (nums[k] == nums[k+1]) k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2,0,0,2,2};
        List<List<Integer>> ans1 = threeSum(nums1);
        System.out.println(ans1);
        List<List<Integer>> ans2 = threeSumOpt(nums1);
        System.out.println(ans2);
    }
}
