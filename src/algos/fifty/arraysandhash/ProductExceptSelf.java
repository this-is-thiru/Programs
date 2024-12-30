package algos.fifty.arraysandhash;

import java.util.Arrays;

public class ProductExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i-1] * nums[i];
        }

        int prod = 1;
        for (int i = n-1; i >0; i--) {
            arr[i] = arr[i-1] * prod;
            prod *= nums[i];
        }

        arr[0] = prod;
        return arr;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int[] ans = productExceptSelf(input);
        System.out.println(Arrays.toString(ans));
    }

}
