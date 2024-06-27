package coding_mafia;

public class NonRepeatedElement {

    private static int nonRepeatedElement(int[] nums, int start, int end) {
        if (end - start == 0) {
            return nums[start];
        }

        int mid = (start + end) / 2;
        if (mid % 2 != 0) {
            if (nums[mid - 1] == nums[mid]) {
                return nonRepeatedElement(nums, mid + 1, end);
            } else {
                return nonRepeatedElement(nums, start, mid);
            }
        } else {
            if (nums[mid] == nums[mid + 1]) {
                return nonRepeatedElement(nums, mid + 1, end);
            } else {
                return nonRepeatedElement(nums, start, mid);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {3, 3, 7, 7, 10, 11, 11};
//        int[] input = {3, 3, 7, 7, 9,9, 10, 11, 11, 12, 12, 16, 16};
        int ans = nonRepeatedElement(input, 0, input.length - 1);
        System.out.println(ans);
    }
}
