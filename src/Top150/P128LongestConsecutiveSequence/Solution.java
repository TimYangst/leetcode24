package Top150.P128LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Set<Integer> numbers = new HashSet<>();
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        for (int i : numbers) {
            if (!numbers.contains(i - 1)) {
                int j = i + 1;
                while (numbers.contains(j))
                    j++;
                result = Math.max(result, j - i);
            }
        }
        return result;
    }
}
