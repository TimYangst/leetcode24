package P560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int[] s = new int[nums.length + 1]; // s[i] = sum of (n0, n1, .. ni-1);
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
            result += counts.getOrDefault(s[i + 1] - k, 0);
            counts.compute(s[i + 1], (key, value) -> (value == null ? 1 : value + 1));
        }
        return result;
    }
}