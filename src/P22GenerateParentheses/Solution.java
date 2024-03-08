package P22GenerateParentheses;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;
        Map<Integer, List<String>> patterns = new HashMap<>();
        patterns.put(0, List.of(""));
        patterns.put(1, List.of("()"));
        patterns.put(2, List.of("(())", "()()"));
        for (int i = 3; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                int k = i - j;
                List<String> firstHalf = patterns.get(j - 1);
                List<String> secondHalf = patterns.get(k);
                for (String first : firstHalf) {
                    String half = "(" + first + ")";
                    for (String second : secondHalf) {
                        current.add(half + second);
                    }
                }
            }
            patterns.put(i, current);
        }
        return patterns.get(n);
    }
}
