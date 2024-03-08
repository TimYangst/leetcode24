package P30SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < words[0].length() * words.length)
            return result;
        Map<String, Integer> wordMapping = new HashMap<>();
        int[] reverseIndex = new int[words.length];
        int size = 0;
        for (int i = 0; i < words.length; i++) {
            if (wordMapping.containsKey(words[i])) {
                reverseIndex[wordMapping.get(words[i])]++;
            } else {
                reverseIndex[size] = 1;
                wordMapping.put(words[i], size);
                size++;
            }
        }
        int[] wordlabels = new int[s.length()];
        for (int i = 0; i <= s.length() - words[0].length(); i++) {
            String cs = s.substring(i, i + words[0].length());
            wordlabels[i] = -1;
            for (String word : wordMapping.keySet()) {
                if (word.equals(cs)) {
                    wordlabels[i] = wordMapping.get(word);
                    break;
                }
            }
        }
        for (int i = 0; i <= s.length() - words[0].length() * words.length; i++) {
            if (check(i, wordlabels, reverseIndex, size, words[0].length(), words.length)) {
                result.add(i);
            }
        }
        return result;
    }

    boolean check(int index, int[] wordlabels, int[] reverseIndex, int size, int wordLength, int totalWords) {
        int[] counts = new int[size];
        for (int i = 0; i < size; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < totalWords; i++) {
            if (wordlabels[index + i * wordLength] == -1)
                return false;
            else
                counts[wordlabels[index + i * wordLength]]++;
        }
        for (int i = 0; i < size; i++) {
            if (counts[i] != reverseIndex[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));

    }
}