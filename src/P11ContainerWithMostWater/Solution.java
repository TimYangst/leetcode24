package P11ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return result;
    }
}