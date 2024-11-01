package P163;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int start = lower;
        for (int current : nums) {
            if (start == current)
                start++;
            else {
                result.add(List.of(start, current - 1));
                start = current + 1;
            }
        }
        if (start <= upper)
            result.add(List.of(start, upper));
        return result;
    }
}
