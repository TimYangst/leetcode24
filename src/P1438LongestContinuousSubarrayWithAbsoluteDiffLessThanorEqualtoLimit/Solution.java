package P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit;

import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length <= 1)
            return nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int b = 0;
        int e = 0;
        map.put(nums[0], 1);
        int result = 1;
        for (e = 1; e < nums.length; e++) {
            map.compute(nums[e],
                    (key, value) -> (value == null ? 1 : value + 1));
            while (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                map.compute(nums[b], (key, value) -> {
                    value--;
                    if (value == 0)
                        return null;
                    return value;
                });
                b++;
            }
            if (e - b + 1 > result)
                result = e - b + 1;
        }
        return result;
    }
}