package Top150.P918MaximumSumCircularSubarray;

class Solution1 {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int result = nums[0];
        int i = 0;
        while (i < nums.length && nums[i] < 0) {
            result = Math.max(result, nums[i]);
            i++;
        }
        if (i == nums.length)
            return result;
        result = nums[i];
        int start = i;
        int remains = 0;
        while (i < nums.length) {
            if (nums[i] < 0) {
                i++;
                remains = 0;
                start = i;
            } else {
                remains = nums[i];
                result = Math.max(result, remains);
                int j = i + 1;
                while (j < start + nums.length && remains + getValue(nums, j) >= 0) {
                    remains += getValue(nums, j);
                    result = Math.max(result, remains);
                    j++;
                }
                i++;
                remains = 0;
                start = i;
            }
        }
        return result;
    }

    int getValue(int[] nums, int j) {
        if (j >= nums.length)
            return nums[j - nums.length];
        return nums[j];
    }
}