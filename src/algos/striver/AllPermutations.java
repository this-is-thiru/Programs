package algos.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {

    private static void allPermutations(int[] nums, List<Integer> ds, int n, int[] map) {
        if (ds.size() == n) {
            System.out.println(ds);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map[i] != -1) continue;
            if (i != 0 && nums[i] == nums[i - 1] && map[i - 1] != -1) continue;

            ds.add(nums[i]);
            map[i] = 1;
            allPermutations(nums, ds, n, map);
            map[i] = -1;
            ds.removeLast();
        }
    }

    private static void allPermutations(int index, int[] nums, int n) {
        if (index == n) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ds.add(nums[i]);
            }
            System.out.println(ds);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            allPermutations(index + 1, nums, n);
            swap(i, index, nums);
        }
    }

    private static void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int[] map = new int[3];
        Arrays.fill(map, -1);
//        allPermutations(input, new ArrayList<>(), input.length, map);
        allPermutations(0, input, 2);
    }


}
