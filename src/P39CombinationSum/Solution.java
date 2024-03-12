package P39CombinationSum;

import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> result = new ArrayList<List<List<Integer>>>();
        for (int i = 0; i <= target; i++) {
            result.add(i, new ArrayList<List<Integer>>());
        }
        List<Integer> empty = new ArrayList<>();
        result.get(0).add(empty);
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            for (int j = candidates[i]; j <= target; j++) {
                if (result.get(j - candidates[i]).size() > 0) {
                    for (List<Integer> current : result.get(j - candidates[i])) {
                        List<Integer> newList = new ArrayList<>(current);
                        newList.add(candidates[i]);
                        result.get(j).add(newList);
                    }
                }
            }
        }
        return result.get(target);
    }
}