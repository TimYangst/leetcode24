package Top150.P918MaximumSumCircularSubarray;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int sum = nums[0];

        int maxC = 0;
        int minC = 0;
        if (nums[0] > 0)
            maxC = nums[0];
        else
            minC = nums[0];

        int i = 1;
        while (i < nums.length) {
            sum += nums[i];
            max_so_far = Math.max(max_so_far, nums[i]);
            min_so_far = Math.min(min_so_far, nums[i]);
            if (maxC + nums[i] >= 0) {
                maxC += nums[i];
                max_so_far = Math.max(max_so_far, maxC);
            } else {
                maxC = 0;
            }
            if (minC + nums[i] <= 0) {
                minC += nums[i];
                min_so_far = Math.min(min_so_far, minC);
            } else {
                minC = 0;
            }
            i++;
        }
        if (max_so_far < 0)
            return max_so_far;
        else
            return Math.max(max_so_far, sum - min_so_far);
    }
}