package algos.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    private static int maxLength(int[] nums) {
        int n = nums.length;

        int maxi = 0;
        int left = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int j = 0; j < n; j++) {
            int freq = frequencyMap.getOrDefault(nums[j], 0);
            freq++;
            frequencyMap.put(nums[j], freq);

            if (frequencyMap.size() > 2) {
                int leftFreq = frequencyMap.get(nums[left]);
                if (leftFreq > 1) {
                    leftFreq--;
                    frequencyMap.put(nums[left], leftFreq);
                } else {
                    frequencyMap.remove(nums[left]);
                }
                left++;
            }

            if (frequencyMap.size() <= 2) {
                maxi = Math.max(maxi, j - left + 1);
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int ans = maxLength(nums);
        System.out.println(ans);
    }
}
