package algos.striver.graphs;

import java.util.*;

public class WordLadder1 {

    private static List<List<String>> minLength(List<String> words, String beginWord, String endWord) {
        Set<String> wordSet = new HashSet<>(words);
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Collections.singletonList(beginWord)));

        List<List<String>> ans = new ArrayList<>();

        int minLength = -1;
        List<String> lastLevelUsedWords = new ArrayList<>();
        int lastSize = 0;
        while (!queue.isEmpty()) {
            List<String> levelWords = queue.poll();
            String word = levelWords.getLast();

            if (levelWords.size() > lastSize) {
                for (String usedWord : lastLevelUsedWords) {
                    wordSet.remove(usedWord);
                }
                lastLevelUsedWords.clear();
                lastSize = levelWords.size();
            }

            if (minLength != -1 && levelWords.size() > minLength) {
                return ans;
            }

            if (word.equals(endWord)) {
                ans.add(levelWords);
                minLength = levelWords.size();
            }

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String tempWord = new String(chars);
                    if (wordSet.contains(tempWord)) {
                        List<String> newLevelWords = new ArrayList<>(levelWords);
                        newLevelWords.add(tempWord);
                        queue.add(newLevelWords);
                        lastLevelUsedWords.add(tempWord);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        List<List<String>> minLength = minLength(Arrays.asList(wordList), beginWord, endWord);
        System.out.println(minLength);
    }
}
