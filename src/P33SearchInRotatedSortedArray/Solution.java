package P33SearchInRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            return -1;
        }
        int x = findMin(nums, 0, nums.length - 1);
        if (nums[x] <= target && nums[nums.length - 1] >= target)
            return findTarget(nums, x, nums.length - 1, target);
        if (x != 0 && nums[0] <= target && target <= nums[x - 1])
            return findTarget(nums, 0, x - 1, target);
        return -1;
    }

    int findMin(int[] nums, int b, int e) {
        if (b == e)
            return b;
        int m = (b + e) / 2;
        if (nums[m + 1] < nums[m]) {
            return m + 1;
        }
        if (nums[m] > nums[b]) {
            return findMin(nums, m + 1, e);
        }
        return findMin(nums, b, m);
    }

    int findTarget(int[] nums, int b, int e, int target) {
        if (b == e) {
            if (nums[b] == target)
                return b;
            return -1;
        }
        int m = (b + e) / 2;
        if (nums[m] >= target)
            return findTarget(nums, b, m, target);
        return findTarget(nums, m + 1, e, target);
    }
}