package P448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int j = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (j == nums.length || nums[j] != i) {
                result.add(i);
            } else if (nums[j] == i) {
                while (j < nums.length && nums[j] == i)
                    j++;
            }
        }
        return result;
    }
}
