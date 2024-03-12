package P45JumpGameII;

class Solution {
    public int jump(int[] nums) {
        int m[] = new int[nums.length];
        m[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m[i] = Math.max(m[i - 1], i + nums[i]);
        }
        int k = 0;
        int result = 0;
        while (k < nums.length - 1) {
            result++;
            k = m[k];
        }
        return result;
    }
}