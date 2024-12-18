package P213HouseRobber;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int l = nums.length;

        // start a first
        int takeLast = nums[0];
        int noTakeLast = 0;
        for (int i = 1; i < l - 1; i++) {
            int tmp = takeLast;
            takeLast = nums[i] + noTakeLast;
            noTakeLast = Math.max(tmp, noTakeLast);
        }
        int result = Math.max(takeLast, noTakeLast);

        // start at second;
        takeLast = nums[1];
        noTakeLast = 0;
        for (int i = 2; i < l; i++) {
            int tmp = takeLast;
            takeLast = nums[i] + noTakeLast;
            noTakeLast = Math.max(tmp, noTakeLast);
        }
        result = Math.max(result, Math.max(takeLast, noTakeLast));
        return result;
    }
}
