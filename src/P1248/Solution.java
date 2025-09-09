package P1248;

class Solution {

    int atMost(int[] nums, int k) {
        if (k < 0)
            return 0;
        int b = 0;
        int current = 0;
        int res = 0;
        for (int e = 0; e < nums.length; e++) {
            if (nums[e] % 2 == 1)
                current++;
            while (current > k && b < nums.length) {
                current -= (nums[b] % 2);
                b++;
            }
            res += e - b + 1;
        }
        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}