package P131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean isPali(String s, int b, int e) {
        while (b < e) {
            if (s.charAt(b) != s.charAt(e))
                return false;
            b++;
            e--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>>[] result = (List<List<String>>[]) new List[s.length() + 1];
        result[0] = List.of(List.of(""));
        if (s.length() == 0)
            return result[0];
        result[1] = List.of(List.of(String.valueOf(s.charAt(0))));
        for (int i = 2; i <= s.length(); i++) {
            result[i] = new ArrayList<>();
            if (isPali(s, 0, i - 1)) {
                result[i].add(List.of(s.substring(0, i)));
            }
            for (int j = 1; j < i; j++) {
                if (isPali(s, j, i - 1)) {
                    String last = s.substring(j, i);
                    for (List<String> list : result[j]) {
                        List<String> newList = new ArrayList<>(list);
                        newList.add(last);
                        result[i].add(newList);
                    }
                }
            }
        }
        return result[s.length()];
    }
}
