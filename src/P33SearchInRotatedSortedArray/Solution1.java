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
        return find(nums, 0, nums.length - 1, target);
    }

    int find(int[] nums, int b, int e, int target) {
        if (b == e) {
            if (nums[b] == target)
                return b;
            return -1;
        }
        int m = (b + e) / 2;
        if (nums[b] < nums[m]) {
            if (nums[b] <= target && target <= nums[m])
                return find(nums, b, m, target);
            return find(nums, m + 1, e, target);
        }
        if (nums[m + 1] <= target && target <= nums[e])
            return find(nums, m + 1, e, target);
        return find(nums, b, m, target);
    }
}
