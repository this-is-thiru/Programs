package algos.fifty.twopointers;

import java.util.Arrays;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left<=right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // stating 1 based indexing
                return new int[]{left+1, right+1};
            } else if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        // Assume input is in asc order
        int[] input = {2,3,4};
        int[] ans = twoSum(input, 6);
        System.out.println(Arrays.toString(ans));
    }
}
