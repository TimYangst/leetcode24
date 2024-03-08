package P26RemoveDuplicatesfromSortedArray;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int i = 0;
        int j = i;
        while (i < nums.length) {
            nums[j] = nums[i];
            i++;
            j++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return j;
    }
}
