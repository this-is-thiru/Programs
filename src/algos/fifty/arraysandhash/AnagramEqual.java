package algos.fifty.arraysandhash;

import java.util.Arrays;

public class AnagramEqual {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        return Arrays.equals(s1, s2);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean isAnagram = isAnagram(s, t);
        System.out.println(isAnagram);
    }
}

