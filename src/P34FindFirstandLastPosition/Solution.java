package P34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0)
            return result;
        result[0] = binarySearch(nums, 0, nums.length - 1, target, false);
        if (result[0] == -1) {
            return result;
        }
        result[1] = binarySearch(nums, result[0], nums.length - 1, target, true);
        return result;
    }

    int binarySearch(int[] nums, int b, int e, int target, boolean findMax) {
        if (b == e) {
            if (nums[b] == target)
                return b;
            return -1;
        }
        int m = (b + e) / 2;
        if (nums[m] == target) {
            if (findMax) {
                if (nums[m] == nums[m + 1])
                    return binarySearch(nums, m + 1, e, target, findMax);
                return m;
            }
            return binarySearch(nums, b, m, target, findMax);
        }
        if (nums[b] <= target && target < nums[m])
            return binarySearch(nums, b, m, target, findMax);
        if (nums[m + 1] <= target && target <= nums[e])
            return binarySearch(nums, m + 1, e, target, findMax);
        return -1;
    }
}