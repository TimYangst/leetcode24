package P377;

import java.util.Arrays;

class Solution {
    int search(int[] f, int[] nums, int target) {
        if (target < 0)
            return 0;
        if (f[target] >= 0)
            return f[target];
        f[target] = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] <= target)
                f[target] += search(f, nums, target - nums[j]);
        }
        return f[target];
    }

    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        Arrays.sort(nums);
        int[] f = new int[target + 1];
        Arrays.fill(f, -1);
        f[0] = 1;
        return search(f, nums, target);
    }
}