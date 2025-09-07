package P560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] s = new int[nums.length + 1];
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = nums[i] + s[i];
            result += count.getOrDefault(s[i + 1] - k, 0);
            count.compute(s[i + 1], (key, value) -> value == null ? 1 : value + 1);
        }
        return result;
    }
}