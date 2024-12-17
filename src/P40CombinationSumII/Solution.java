package P40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    void search(int target, int[] candidates, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index >= candidates.length)
            return;

        int j = index + 1;
        while (j < candidates.length && candidates[j] == candidates[index]) {
            j++;
        }
        search(target, candidates, j, current, result);
        int tmp = target;
        for (int i = index; i < j && target >= candidates[i]; i++) {
            current.add(candidates[i]);
            target -= candidates[i];
            search(target, candidates, j, current, result);
        }
        while (target < tmp) {
            current.remove(current.size() - 1);
            target += candidates[index];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        search(target, candidates, 0, current, result);
        return result;
    }
}
