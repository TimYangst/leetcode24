package P55JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int[] m = new int[nums.length];
        m[0] = nums[0];
        if (nums.length == 1)
            return true;
        for (int i = 1; i < nums.length; i++) {
            if (m[i - 1] < i)
                return false;
            m[i] = Math.max(m[i - 1], nums[i] + i);
        }
        return true;
    }
}