package algos.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind >= arr.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (ind > 0 && arr[ind] == arr[ind - 1]) {
            findCombinations(ind + 1, arr, target, ans, ds);
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind + 1, arr, target - arr[ind], ans, ds);
            ds.removeLast();
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(arr);
        int target = 8;
        List<List<Integer>> ls = combinationSum(arr, target);
        System.out.println("Combinations are: ");
        for (List<Integer> l : ls) {
            for (Integer integer : l) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

