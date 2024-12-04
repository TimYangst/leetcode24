package P698;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k <= 1)
            return true;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);
        return search(nums.length - 1, nums, new int[k], sum / k);
    }

    boolean search(int index, int[] nums, int[] current, int target) {
        Set<Integer> tried = new HashSet<>();
        for (int i = 0; i < current.length; i++) {
            if (current[i] + nums[index] <= target && !tried.contains(current[i])) {
                tried.add(current[i]);
                current[i] += nums[index];
                if (index == 0) {
                    return true;
                } else {
                    if (search(index - 1, nums, current, target)) {
                        return true;
                    }
                }
                current[i] -= nums[index];
            }
        }
        return false;
    }
}