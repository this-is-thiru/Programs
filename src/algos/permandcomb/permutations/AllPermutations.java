package algos.permandcomb.permutations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AllPermutations {
    private static void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int number(int[] arr) {
        StringBuilder str = new StringBuilder();
        for (int j : arr) {
            str.append(j);
        }
        return Integer.parseInt(str.toString());
    }

    private static void allPermutations(int index, int[] nums, List<Integer> ds, int n) {
        if (index == n) {
            ds.add(number(nums));
            return;
        }

        for (int i = index; i <= n; i++) {
            swap(index, i, nums);
            allPermutations(index + 1, nums, ds, n);
            swap(i, index, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> ds = new ArrayList<>();
        allPermutations(0, nums, ds, nums.length - 1);
        ds.sort(Comparator.naturalOrder());
        System.out.println(ds);
    }
}
