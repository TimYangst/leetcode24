package P360;

class Solution {
    int apply(int v, int a, int b, int c) {
        return (v * v * a) + (b * v) + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (b >= 0)
                    result[i] = apply(nums[i], a, b, c);
                else
                    result[nums.length - i - 1] = apply(nums[i], a, b, c);
            }
            return result;
        }
        boolean reverse = (a > 0);
        int s = 0;
        int t = nums.length - 1;
        int start = reverse ? nums.length - 1 : 0;
        while (s <= t) {
            int rs = apply(nums[s], a, b, c);
            int rt = apply(nums[t], a, b, c);
            if (reverse) {
                if (rs > rt) {
                    s++;
                    result[start--] = rs;
                } else {
                    t--;
                    result[start--] = rt;

                }
            } else {
                if (rs < rt) {
                    s++;
                    result[start++] = rs;
                } else {
                    t--;
                    result[start++] = rt;
                }
            }
        }
        return result;
    }
}