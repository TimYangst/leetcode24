package P216;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean boundryCheck(int remains, int min, int max, int target) {
        if ((min + min + remains - 1) * remains / 2 > target)
            return false;
        if ((max + max - remains + 1) * remains / 2 < target)
            return false;
        return true;
    }

    void search(int k, int target, int min, int max, List<Integer> current,
            List<List<Integer>> result) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (k <= 0 || target <= 0)
            return;
        if (!boundryCheck(k, min, max, target))
            return;
        for (int i = min; i + k - 1 <= max; i++) {
            current.add(i);
            search(k - 1, target - i, i + 1, max, current, result);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        search(k, n, 1, 9, current, result);
        return result;
    }
}