package P18FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 3)
            return result;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length - 3) {
            j = nums.length - 1;
            while (i < j - 2) {
                if (isPossible(nums, i, j, target)) {
                    twoSum(nums, i, j, target, result);
                }
                j--;
                while (i < j - 2 && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
            i++;
            while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }

    boolean isPossible(int[] nums, int b, int e, int target) {
        return (long) nums[b] * 3 + (long) nums[e] <= target &&
                (long) nums[b] + (long) nums[e] * 3 >= target;
    }

    int compare(int[] nums, int i1, int i2, int i3, int i4, int target) {
        long sum = (long) (nums[i1] + nums[i4]) + (long) (nums[i2] + nums[i3]);
        if (sum < target)
            return -1;
        else if (sum > target)
            return 1;
        return 0;
    }

    void twoSum(int[] nums, int b, int e, int target, List<List<Integer>> result) {
        int i = b + 1;
        int j = e - 1;
        while (i < j) {
            int cmpResult = compare(nums, b, i, j, e, target);
            if (cmpResult == 0) {
                result.add(List.of(nums[b], nums[i], nums[j], nums[e]));
                i++;
                while (i < j && nums[i] == nums[i - 1])
                    i++;
                j--;
                while (i < j && nums[j] == nums[j + 1])
                    j--;
            } else if (cmpResult < 0) {
                i++;
                while (i < j && nums[i] == nums[i - 1])
                    i++;
            } else {
                j--;
                while (i < j && nums[j] == nums[j + 1])
                    j--;
            }
        }
    }
}