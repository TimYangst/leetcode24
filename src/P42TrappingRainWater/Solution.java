package P42TrappingRainWater;

class Solution {
    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int i = 0;
        int j = height.length - 1;
        int total = 0;
        int lh = height[i];
        int rh = height[j];
        while (i < j - 1) {
            if (lh <= rh) {
                i++;
                if (height[i] < lh) {
                    total += lh - height[i];
                } else {
                    lh = height[i];
                }
            } else {
                j--;
                if (height[j] < rh) {
                    total += rh - height[j];
                } else {
                    rh = height[j];
                }
            }
        }
        return total;
    }
}
