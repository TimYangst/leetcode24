package P53MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int i = 0;
        if (nums.length == 0)
            return 0;
        int current = 0;
        while (i < nums.length) {
            if (current + nums[i] > result)
                result = current + nums[i];

            if (current + nums[i] > 0) {
                current += nums[i];
            } else
                current = 0;
            i++;
        }
        return result;
    }
}
