package P213HouseRobber;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[][] f = new int[nums.length][2];
        int[][] g = new int[nums.length][2];

        // f[0][0] = g[0][0] = 0;
        f[0][1] = nums[0];
        g[0][1] = nums[0];
        f[1][0] = nums[1];
        g[1][0] = nums[1];
        g[1][1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            f[i][0] = nums[i] + g[i - 2][0];
            f[i][1] = nums[i] + g[i - 2][1];
            g[i][0] = Math.max(g[i - 1][0], f[i][0]);
            g[i][1] = Math.max(g[i - 1][1], f[i][1]);
        }

        int result = Math.max(g[nums.length - 1][0],
                Math.max(g[nums.length - 2][0], g[nums.length - 2][1]));
        return result;
    }
}