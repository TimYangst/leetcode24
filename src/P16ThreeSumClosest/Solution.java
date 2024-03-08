package P16ThreeSumClosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int result = 0;
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int current = nums[i] + nums[j] + nums[k];
                if (current == target) {
                    return target;
                }
                if (current > target) {
                    if (current - target < closest) {
                        closest = current - target;
                        result = current;
                    }
                    k--;
                } else if (current < target) {
                    if (target - current < closest) {
                        closest = target - current;
                        result = current;
                    }
                    j++;
                }
            }
            i++;
        }
        return result;
    }
}