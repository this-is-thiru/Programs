package algos.striver.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLadder2 {
    private record Pair(String word, int level) { }

    private static int minLength(String[] words, String beginWord, String endWord) {
        Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()){
            Pair element = queue.poll();
            String word = element.word;
            int level = element.level;

            if (word.equals(endWord)) {
                return level;
            }

            for (int i=0; i<word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char ch = 'a'; ch<='z'; ch++) {
                    chars[i] = ch;
                    String tempWord = new String(chars);
                    if (wordSet.contains(tempWord)) {
                        queue.add(new Pair(tempWord, level+1));
                        wordSet.remove(tempWord);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        int minLength = minLength(wordList, beginWord, endWord);
        System.out.println(minLength);
    }
}
