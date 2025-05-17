package algos.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChars {
    private static int longestSubString(String str) {
        Map<Character, Integer> charLastIndex = new HashMap<>();

        int left = 0;
        int maxi = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer lastOccurrence = charLastIndex.get(ch);
            charLastIndex.put(ch, i);
            if (lastOccurrence != null) {
                left = Math.max(left, lastOccurrence + 1);
            }
            int length = i - left + 1;
            maxi = Math.max(maxi, length);
        }
        return maxi;
    }

    public static void main(String[] args) {
        String str = "cadbzabcd";
        int ans = longestSubString(str);
        System.out.println(ans);
    }
}
