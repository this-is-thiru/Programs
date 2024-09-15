package algos.striver;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
    private static void allSubsetsTemp(int index, int[] nums, List<Integer> ds, int n) {
        System.out.println("-->" + index + ", " + ds);
        if (index == n) {
            System.out.println(index + ", " + ds);
            return;
        }

        for (int i = index; i < n; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            allSubsetsTemp(i + 1, nums, ds, n);
            ds.removeLast();
        }
    }

    private static void allSubsets1(int index, int[] nums, List<Integer> ds, int n) {
        System.out.println("--->" + n + ", " + ds);

        for (int i = index; i < n; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            allSubsets1(i + 1, nums, ds, n);
            ds.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2};
        allSubsetsTemp(0, input, new ArrayList<>(), input.length);
//        allSubsets1(0, input, new ArrayList<>(), input.length);
    }


}
