package P40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<List<Integer>>> result = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            result.add(i, new ArrayList<>());
        }
        result.get(0).add(new ArrayList<>());
        Arrays.sort(candidates);
        Map<Integer, Integer> count = new LinkedHashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            if (!count.containsKey(candidates[i])) {
                count.put(candidates[i], 1);
            } else {
                count.put(candidates[i], count.get(candidates[i]) + 1);
            }
        }
        for (int current : count.keySet()) {
            Map<Integer, List<List<Integer>>> newResult = new HashMap<>();
            int countCurrent = count.get(current);
            for (int i = 0; i <= target - current; i++) {
                if (!result.get(i).isEmpty()) {
                    for (List<Integer> exist : result.get(i)) {
                        List<Integer> newCombination = new ArrayList<>(exist);
                        int v = i;
                        for (int j = 1; j <= countCurrent; j++) {
                            v += current;
                            if (v > target) {
                                break;
                            }
                            newCombination.add(current);
                            List<List<Integer>> toAdd;
                            if (!newResult.containsKey(v)) {
                                toAdd = new ArrayList<>();
                                newResult.put(v, toAdd);
                            } else {
                                toAdd = newResult.get(v);
                            }
                            toAdd.add(List.copyOf(newCombination));
                        }
                    }
                }
            }
            for (Map.Entry<Integer, List<List<Integer>>> entry : newResult.entrySet()) {
                result.get(entry.getKey()).addAll(entry.getValue());
            }
        }
        return result.get(target);
    }
}
