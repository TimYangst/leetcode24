package P41FirstMissingPositive;

class Solution {

    private int splitArr(int[] nums) {
        int b = 0;
        int e = nums.length - 1;
        while (b <= e) {
            if (nums[b] <= 0) {
                int tmp = nums[e];
                nums[e] = nums[b];
                nums[b] = tmp;
                e--;
            } else {
                b++;
            }
        }
        return e + 1;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        int l = splitArr(nums); // l is length of pos element.
        if (l == 0)
            return 1;
        for (int i = 0; i < l; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < l)
                nums[index] = -Math.abs(nums[index]);
        }
        for (int i = 0; i < l; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return l + 1;
    }
}