package algos.striver;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
    private static void allSubsetsRecursion(int index, int prev_index, int[] nums, List<Integer> ds, int n) {
        if (index == n) {
            System.out.println(ds);
            return;
        }

        ds.add(nums[index]);
        allSubsetsRecursion(index + 1, index, nums, ds, n);
        ds.removeLast();
        if (prev_index == -1 || nums[prev_index] != nums[index]) {
            allSubsetsRecursion(index + 1, prev_index, nums, ds, n);
        }
    }

    private static void allSubsets(int index, int[] nums, List<Integer> ds, int n) {
        System.out.println("--->" + n + ", " + ds);

        for (int i = index; i < n; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            allSubsets(i + 1, nums, ds, n);
            ds.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        allSubsetsRecursion(0, -1, input, new ArrayList<>(), input.length);
//        allSubsets(0, input, new ArrayList<>(), input.length);
    }


}
