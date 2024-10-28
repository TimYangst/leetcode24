package P930;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        if (goal == 0) {
            int i = 0;
            int j = 0;
            boolean cons = false;
            while (j < nums.length) {
                if (nums[j] == 0 && !cons) {
                    i = j;
                    cons = true;
                } else if (nums[j] == 1 && cons) {
                    cons = false;
                    result += (j - i) * (j - i + 1) / 2;
                }
                j++;
            }
            if (cons) {
                result += (j - i) * (j - i + 1) / 2;
            }
            return result;
        }
        int i = 0;
        int j = 0;
        int current = nums[0];
        while (j < nums.length - 1 && current < goal) {
            j++;
            current += nums[j];
        }
        if (current < goal)
            return 0;

        while (j < nums.length) {
            int previousJ = j;
            while (j + 1 < nums.length && nums[j + 1] == 0) {
                j++;
            }
            int previousI = i;
            while (i < j && nums[i] == 0) {
                i++;
            }
            result += (i - previousI + 1) * (j - previousJ + 1);
            j++;
            i++;
        }
        return result;
    }
}
