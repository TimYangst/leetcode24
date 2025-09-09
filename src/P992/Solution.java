package P992;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int atMost(int[] nums, int k) {
        if (k <= 0)
            return 0;
        int b = 0;
        Map<Integer, Integer> current = new HashMap<>();
        int result = 0;
        for (int e = 0; e < nums.length; e++) {
            current.compute(nums[e], (key, v) -> v == null ? 1 : v + 1);
            while (current.size() > k) {
                current.compute(nums[b], (key, v) -> v == 1 ? null : v - 1);
                b++;
            }
            result += (e - b + 1);
        }
        return result;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}