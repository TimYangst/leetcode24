package Top150.P238ProductOfArrayExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        if (l <= 1)
            return result;
        int[] f = new int[l];
        int[] r = new int[l];
        f[0] = 1;
        r[l - 1] = 1;
        for (int i = 1; i < l; i++) {
            f[i] = nums[i - 1] * f[i - 1];
            r[l - 1 - i] = nums[l - i] * r[l - i];
        }
        for (int i = 0; i < l; i++) {
            result[i] = f[i] * r[i];
        }
        return result;
    }
}
