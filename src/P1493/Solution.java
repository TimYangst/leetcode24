package P1493;

class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length && nums[j] == 1)
            j++;
        if (j == nums.length)
            return nums.length - 1;
        j++;
        while (j < nums.length && nums[j] == 1)
            j++;
        result = j - i - 1;
        int current = result;
        while (j < nums.length) {
            j++;
            while (i < j && nums[i] == 1) {
                current--;
                i++;
            }
            i++;
            while (j < nums.length && nums[j] == 1) {
                current++;
                j++;
            }
            result = Math.max(result, current);
        }
        return result;

    }
}