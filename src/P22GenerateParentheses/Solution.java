package P22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return List.of();
        if (n == 1)
            return List.of("()");
        List<String>[] patterns = (List<String>[]) (new List[n + 1]);

        patterns[0] = List.of("");
        patterns[1] = List.of("()");
        patterns[2] = List.of("(())", "()()");
        for (int i = 3; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int k = i - j - 1;
                List<String> firstHalf = patterns[j];
                List<String> secondHalf = patterns[k];
                for (String first : firstHalf) {
                    for (String second : secondHalf) {
                        current.add(first + '(' + second + ')');
                    }
                }
            }
            patterns[i] = current;
        }
        return patterns[n];
    }
}