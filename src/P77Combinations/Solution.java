package P77Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        search(1, 0, n, k, current, result);
        return result;
    }

    void search(int level, int last, int n, int k, List<Integer> current, List<List<Integer>> result) {
        for (int i = last + 1; i <= n - (k - level); i++) {
            current.add(i);
            if (level == k) {
                result.add(List.copyOf(current));
            } else {
                search(level + 1, i, n, k, current, result);
            }
            current.remove(level - 1);
        }
    }
}
