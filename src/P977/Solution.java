package P977;

class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0)
            return nums;

        int b = 0;
        int e = nums.length - 1;
        int loc = -1;
        while (b <= e) {
            int mid = b + (e - b) / 2;
            if (nums[mid] >= 0) {
                loc = mid;
                e = mid - 1;
            } else
                b = mid + 1;
        }
        if (loc == -1)
            loc = nums.length;

        int i = loc;
        int j = loc - 1;
        int[] res = new int[nums.length];
        int k = 0;
        while (j >= 0 && i < nums.length) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[k++] = nums[i] * nums[i];
                i++;
            } else {
                res[k++] = nums[j] * nums[j];
                j--;
            }
        }
        while (j >= 0) {
            res[k++] = nums[j] * nums[j];
            j--;
        }
        while (i < nums.length) {
            res[k++] = nums[i] * nums[i];
            i++;
        }
        return res;
    }
}