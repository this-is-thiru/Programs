package algos.subarray.substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    private static int longestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();

        int ans = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char tempChar = s.charAt(right);
            if (charIndexMap.containsKey(tempChar)) {
                left = charIndexMap.get(tempChar) + 1;
            }
            ans = Math.max(ans, right - left + 1);
            charIndexMap.put(tempChar, right);
            right++;
        }

        return ans;
    }

    private static int greedy(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                maxLength = Math.max(j - i + 1, maxLength);
                set.add(s.charAt(j));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int ans = longestSubstring(input);
        System.out.println(ans);
    }
}
