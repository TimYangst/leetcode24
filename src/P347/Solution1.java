package P347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.compute(nums[i], (key, v) -> (v == null ? 1 : v + 1));
        }
        int[][] result = new int[counter.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        Arrays.sort(result, (a, b) -> (b[1] - a[1]));
        int[] returnArr = new int[k];
        for (int i = 0; i < k; i++) {
            returnArr[i] = result[i][0];
        }
        return returnArr;
    }
}