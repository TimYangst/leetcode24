package P49GroupAnagrams;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0)
            return result;
        if (strs.length == 1) {
            List<String> current = List.of(strs[0]);
            result.add(current);
            return result;
        }
        int[] parent = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= strs.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                int ancester = findAncester(parent, j);
                if (j == ancester) {
                    if (isAnagrams(strs[j], strs[i])) {
                        merge(parent, j, i);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < strs.length; i++) {
            int ancester = findAncester(parent, i);
            if (i == ancester) {
                List<String> current = new ArrayList<>();
                current.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (findAncester(parent, j) == i) {
                        current.add(strs[j]);
                    }
                }
                result.add(current);
            }
        }
        return result;
    }

    boolean isAnagrams(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            count[b.charAt(i) - 'a']--;
            if (count[b.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    int findAncester(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        int ancester = findAncester(parent, parent[i]);
        parent[i] = ancester;
        return ancester;
    }

    void merge(int[] parent, int i, int j) {
        int p1 = findAncester(parent, i);
        int p2 = findAncester(parent, j);
        parent[p2] = p1;
    }
}