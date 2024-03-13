package P46Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        do {
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                current.add(nums[i]);
            }
            result.add(current);
            int k = -1;
            int i = 0;
            while (i < nums.length - 1) {
                if (nums[i] < nums[i + 1]) {
                    k = i;
                }
                i++;
            }
            if (k == -1)
                break;
            int l = k + 1;
            for (int j = k + 2; j < nums.length; j++) {
                if (nums[j] > nums[k] && nums[j] < nums[l]) {
                    l = j;
                }
            }
            int tmp = nums[k];
            nums[k] = nums[l];
            nums[l] = tmp;
            reverse(nums, k + 1, nums.length - 1);
        } while (true);
        return result;
    }

    void reverse(int[] nums, int b, int e) {
        while (b < e) {
            int tmp = nums[b];
            nums[b] = nums[e];
            nums[e] = tmp;
            b++;
            e--;
        }
    }
}