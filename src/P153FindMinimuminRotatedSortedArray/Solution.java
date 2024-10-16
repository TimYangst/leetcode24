package P153FindMinimuminRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int b = 0;
        int e = nums.length - 1;
        while (b < e) {
            if (nums[b] < nums[e])
                return nums[b];
            int mid = (b + e) / 2;
            if (nums[mid] < nums[b]) {
                e = mid;
            } else {
                b = mid + 1;
            }
        }
        return nums[b];
    }
}
