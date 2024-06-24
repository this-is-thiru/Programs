package coding_mafia;

import java.util.Arrays;

public class AbsentNumber {

    private static int[] absentNumber(int n, int[] arr) {

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (num < 0 || num > n - 1) {
                continue;
            }
            ans[num] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        int[] ans = absentNumber(arr.length, arr);
        System.out.println(Arrays.toString(ans));
    }
}
