package P47PermutationsII;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        Arrays.sort(nums);
        do {
            result.add(Arrays.stream(nums).boxed().toList());
            int k = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1])
                    k = i;
            }
            if (k == -1)
                break;
            int l = k + 1;
            for (int j = k + 2; j < nums.length; j++) {
                if (nums[k] < nums[j] && nums[j] <= nums[l])
                    l = j;
            }

            swap(nums, k, l);
            reverse(nums, k + 1, nums.length - 1);
        } while (true);

        return result;
    }

    void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    void reverse(int[] nums, int b, int e) {
        while (b < e) {
            swap(nums, b, e);
            b++;
            e--;
        }
    }
}