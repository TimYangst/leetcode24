package P347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.compute(num, (key, value) -> {
                if (value == null) return 1;
                return value + 1;
            });
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<Integer>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        if (k == 0) return new int[0];
        int[] result = new int[k];
        int t = 0;
        for (int index = nums.length; index > 0; index --) {
            if (bucket[index] != null) {
                for (int num : bucket[index]) {
                    result[t++] = num;
                    if (t >= k) break;
                }
            }
            if (t >= k) break;
        }
        return result;
    }
}