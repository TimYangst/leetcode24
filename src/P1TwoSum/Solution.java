package P1TwoSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndex = new HashMap<>();
        int[] result = new int[2];
        for (int index = 0; index < nums.length; index++) {
            int remains = target - nums[index];
            if (valueIndex.containsKey(remains)) {
                result[0] = valueIndex.get(remains);
                result[1] = index;
                break;
            }
            valueIndex.put(nums[index], index);
        }
        return result;
    }
}