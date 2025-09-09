package P1248;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int current = 0;
        int result = 0;
        for (int x : nums) {
            current += (x % 2);
            result += count.getOrDefault(current - k, 0);
            count.compute(current, (key, value) -> (value == null ? 1 : value + 1));
        }
        return result;
    }
}