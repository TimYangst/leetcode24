package P300LongestIncreasingSubsequence;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int f[] = new int[nums.length + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        int result = 1;
        f[0] = Integer.MIN_VALUE;
        f[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int b = 0;
            int e = result;
            while (b < e) {
                int mid = (b + e) / 2;
                if (f[mid + 1] < nums[i]) {
                    b = mid + 1;
                } else {
                    e = mid;
                }
            }
            if (b == result) {
                result = b + 1;
            }
            f[b + 1] = Math.min(f[b + 1], nums[i]);
        }
        return result;
    }
}