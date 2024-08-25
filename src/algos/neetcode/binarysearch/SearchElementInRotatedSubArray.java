package algos.neetcode.binarysearch;

// Array don't have duplicate elements
public class SearchElementInRotatedSubArray {

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;

        int ans = searchElementInRotatedSubArray(input, input.length - 1, target);
        System.out.println(ans);
    }

    private static int searchElementInRotatedSubArray(int[] nums, int n, int target) {

        int left = 0, right = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
