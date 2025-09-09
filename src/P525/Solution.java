package P525;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) return 0;
        int result = 0;
        int current = 0;
        Map<Integer, Integer> valueMap = new HashMap<>();
        valueMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                current -= 1;
            } else current += 1;
            if (valueMap.containsKey(current)) {
                result = Math.max(result, i - valueMap.get(current));
            } else {
                valueMap.put(current, i);
            }
        }
        return result;
    }
}