package algos.subarray;

public class MaxTurbulentArray {

    private static int turbulentArray(int[] nums) {
        int start = 0, maxSize = 0;
        Character previousChar = null;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                if (previousChar == null || previousChar == '>') {
                    maxSize = Math.max(maxSize, i-start-1);
                } else {
                    start = i-1;
                }
                previousChar = '<';
            } else {
                if (previousChar == null || previousChar == '<') {
                    maxSize = Math.max(maxSize, i-start-1);
                } else {
                    start = i-1;
                }
                previousChar = '>';
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] input = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int ans = turbulentArray(input);
        System.out.println(ans);
    }
}
