package algos.neetcode.binarysearch;

public class MinInRotatedArray {
    public static void main(String[] args) {
        int[] input = {4, 5, 6, 0, 1, 2,3};

        int ans = minElementInRotatedSubArray(input, input.length - 1);
        System.out.println(ans);
    }

    private static int minElementInRotatedSubArray(int[] nums, int n) {
        int left = 0, right = n;

        int min = nums[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] <= nums[mid]) {
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }
        }


        return min;
    }
}
