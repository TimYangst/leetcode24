package P565;

class Solution {
    public int arrayNesting(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int result = 0;
        int visited = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int current = i;
            while (nums[current] != -1) {
                count++;
                int next = nums[current];
                nums[current] = -1;
                visited++;
                current = next;
            }
            if (count > result)
                result = count;
            if (nums.length - visited < result)
                break;
        }
        return result;
    }
}