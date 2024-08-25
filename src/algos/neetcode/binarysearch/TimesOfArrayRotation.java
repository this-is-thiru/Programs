package algos.neetcode.binarysearch;

public class TimesOfArrayRotation {


    private static int timesOfArrayRotation(int[] nums, int n) {

        int left = 0, right = n;
        int min =  nums[0];
        int minIndex = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                minIndex = nums[left] < min ? left : minIndex;
                min = Math.min(nums[left], min);
                left = mid+1;
            } else {
                minIndex = nums[mid] < min ? mid : minIndex;
                min = Math.min(nums[mid], min);
                right = mid-1;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};

        int ans = timesOfArrayRotation(input, input.length - 1);
        System.out.println(ans);
    }

}
