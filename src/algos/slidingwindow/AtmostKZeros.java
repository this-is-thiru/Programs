package algos.slidingwindow;

public class AtmostKZeros {
    private static int maxLength(int[] nums, int k) {
        int n = nums.length;
        int zeros = 0;

        int left = 0;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            if (zeros <= k) {
                int len = i - left + 1;
                maxi = Math.max(len, maxi);
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};

//        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int ans = maxLength(nums, k);
        System.out.println(ans);
    }
}
