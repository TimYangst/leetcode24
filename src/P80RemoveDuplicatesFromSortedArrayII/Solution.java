package P80RemoveDuplicatesFromSortedArrayII;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            nums[i++] = nums[j++];
            if (j < nums.length && nums[j] == nums[j - 1]) {
                nums[i++] = nums[j++];
            }
            while (j < nums.length && nums[j] == nums[j - 1])
                j++;
        }
        return i;
    }
}