package P31NextPermutation;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int k = -1;
        for (int i = 0; i <= nums.length - 2; i++) {
            if (nums[i] < nums[i + 1])
                k = i;
        }
        if (k == -1)
            reverse(nums, 0, nums.length);
        else {
            int j = k + 1;
            for (int l = j + 1; l < nums.length; l++)
                if (nums[l] > nums[k])
                    j = l;
            int tmp = nums[k];
            nums[k] = nums[j];
            nums[j] = tmp;
            reverse(nums, k + 1, nums.length);
        }
    }

    void reverse(int[] nums, int b, int e) {
        int m = (b + e) / 2;
        for (int i = b; i < m; i++) {
            int tmp = nums[i];
            nums[i] = nums[e - 1 - (i - b)];
            nums[e - 1 - (i - b)] = tmp;
        }
    }
}