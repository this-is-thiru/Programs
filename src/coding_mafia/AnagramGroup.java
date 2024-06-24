package coding_mafia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramGroup {

    private static String ascendingOrder(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] input = {"cat", "dog", "tac", "god", "act"};

        Map<String, Integer> anagramMap = new HashMap<>();

        for (String str : input) {
            String modifiedString = ascendingOrder(str);
            int count = anagramMap.getOrDefault(modifiedString, 0);
            anagramMap.put(modifiedString, count + 1);
        }

        System.out.println("Anagram Group: " + anagramMap);

        int[] tempArray = new int[anagramMap.values().size()];

        int count = 0;
        for (int num : anagramMap.values()) {
            tempArray[count] = num;
            count++;
        }

        Arrays.sort(tempArray);

        System.out.println(Arrays.toString(tempArray));
    }


}
