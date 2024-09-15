package telegram;

import java.util.HashMap;
import java.util.Map;

public class UnCommonNumber {
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num%10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }

    private static int unCommonNumber(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (int num: nums2) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int sum = 0;
        for (Integer num: map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }

        while (sum > 10) {
            sum = sumOfDigits(sum);
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] input1 = {123, 45, 7890, 67, 2, 90}, input2 = {45, 7890, 123};
        int[] input1 = {6,7,12,70,44}, input2 = {8,6,70,44};

        int ans = unCommonNumber(input1, input2);
        System.out.println(ans);
    }
}
