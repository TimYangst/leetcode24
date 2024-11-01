package P163;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(List.of(lower, upper));
            return result;
        }
        int i = 0;
        while (i < nums.length && nums[i] == lower + i) {
            i++;
        }
        if (i == nums.length) {
            if (nums[i - 1] == upper)
                return result;
            else {
                result.add(List.of(nums[i - 1] + 1, upper));
                return result;
            }
        }
        int last = lower;
        if (i != 0) {
            last = nums[i - 1] + 1;
        }

        while (i < nums.length) {
            result.add(List.of(last, nums[i] - 1));
            last = nums[i] + 1;
            i++;
            while (i < nums.length && nums[i] == last) {
                last = nums[i] + 1;
                i++;
            }
        }

        if (nums[i - 1] != upper) {
            result.add(List.of(last, upper));
        }
        return result;
    }
}