package P334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int minValue = nums[0];
        boolean[] hasSmaller = new boolean[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (minValue < nums[i])
                hasSmaller[i] = true;
            else
                minValue = nums[i];
        }
        int maxValue = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (maxValue > nums[i]) {
                if (hasSmaller[i])
                    return true;
            } else
                maxValue = nums[i];
        }
        return false;
    }
}