package P55JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentMax < i)
                return false;
            currentMax = Math.max(currentMax, nums[i] + i);
        }
        return true;
    }
}