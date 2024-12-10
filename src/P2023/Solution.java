package P2023;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numOfPairs(String[] nums, String target) {
        int result = 0;
        Map<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (target.startsWith(nums[i])) {
                String end = target.substring(nums[i].length());
                result += counter.getOrDefault(end, 0);
            }
            if (target.endsWith(nums[i])) {
                String start = target.substring(0, target.length() - nums[i].length());
                result += counter.getOrDefault(start, 0);
            }
            counter.compute(nums[i], (k, v) -> (v == null ? 1 : v + 1));
        }
        return result;
    }
}
