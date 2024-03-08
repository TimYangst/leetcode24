package P35SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    int binarySearch(int[] nums, int b, int e, int target) {
        if (b == e) {
            if (nums[b] >= target)
                return b;
            return b + 1;
        }
        int m = (b + e) / 2;
        if (nums[m] == target)
            return m;
        if (target < nums[m]) {
            return binarySearch(nums, b, m, target);
        }
        return binarySearch(nums, m + 1, e, target);
    }
}