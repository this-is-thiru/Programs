package algos.striver;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
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
        int[] arr = {2, 3, 6, 7};
        int target = 7;
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

