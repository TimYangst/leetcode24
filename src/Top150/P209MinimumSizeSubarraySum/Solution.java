package Top150.P209MinimumSizeSubarraySum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            if (nums[0] >= target)
                return 1;
            return 0;
        }
        int i = 0;
        int j = i;
        int s = 0;
        int result = 0;
        while (j < nums.length) {
            if (s < target) {
                while (j < nums.length && s < target) {
                    s += nums[j];
                    j++;
                }
                if (s < target)
                    break;
                while (s - nums[i] >= target) {
                    s -= nums[i];
                    i++;
                }
                if (result == 0 || j - i < result)
                    result = j - i;
            } else {
                s -= nums[i];
                i++;
            }
        }
        return result;
    }
}
