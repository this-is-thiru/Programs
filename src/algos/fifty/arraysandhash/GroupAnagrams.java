package algos.fifty.arraysandhash;

import java.util.*;

public class GroupAnagrams {
    private static List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: input) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (map.containsKey(sortedString)) {
                List<String> list = map.get(sortedString);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedString, list);
            }
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> ans = groupAnagrams(input);
        System.out.println(ans);
    }
}
