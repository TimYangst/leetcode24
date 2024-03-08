package P15ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        Arrays.sort(nums);
        int i = 0;
        while (i <= nums.length - 3) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> current = List.of(nums[i], nums[j], nums[k]);
                    result.add(current);
                    k--;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                    j++;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                }
            }
            i++;
            while (i <= nums.length - 3 && nums[i] == nums[i - 1])
                i++;
        }
        return result;
    }
}