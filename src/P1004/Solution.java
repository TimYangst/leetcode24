package P1004;

class Solution {

    public int longestOnes(int[] nums, int k) {
        if (k >= nums.length)
            return k;
        int result = 0;
        if (k == 0) {
            int current = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    current = 0;
                else
                    current++;
                if (current > result)
                    result = current;
            }
            return result;
        }
        int i = 0;
        int j = 0;
        int taken = (nums[0] == 0) ? 1 : 0;
        result = 1;
        while (j < nums.length - 1) {
            j++;
            if (nums[j] == 0)
                taken++;
            while (taken > k) {
                if (nums[i] == 0)
                    taken--;
                i++;
            }
            if (j - i + 1 > result)
                result = j - i + 1;
        }
        return result;
    }
}