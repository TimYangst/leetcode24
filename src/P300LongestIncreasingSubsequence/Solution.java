package P300LongestIncreasingSubsequence;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int f[] = new int[nums.length + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        int result = 0;
        f[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int b = 0;
            int e = result;
            int pos = 0;
            while (b <= e) {
                int mid = b + (e - b) / 2;
                if (f[mid] < nums[i]) {
                    pos = mid;
                    b = mid + 1;
                } else
                    e = mid - 1;
            }
            f[pos + 1] = Math.min(f[pos + 1], nums[i]);
            result = Math.max(pos + 1, result);
        }
        return result;
    }
}