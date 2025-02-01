package algos.striver.dp.subsequences;

public class MaximumNonAdjacentSum {
    private static int maximumNonAdjacentSum(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }

        int pick = nums[index] + maximumNonAdjacentSum(index - 2, nums);
        int notPick = maximumNonAdjacentSum(index - 1, nums);

        return Math.max(pick, notPick);
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 4};
        int[] arr = {2,1,4,9};
        int ans = maximumNonAdjacentSum(arr.length-1, arr);
        System.out.println("Max sum: " + ans);
    }
}
