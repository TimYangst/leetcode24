package P448;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int v : nums) {
            int x = Math.abs(v);
            if (nums[x - 1] > 0)
                nums[x - 1] = -nums[x - 1];
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0)
                result.add(i);
        }
        return result;
    }
}