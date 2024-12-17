package P90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> current = new ArrayList<>();
        current.add(List.of());
        Arrays.sort(nums);
        int j = 0;
        while (j < nums.length) {
            int k = j + 1;
            while (k < nums.length && nums[k] == nums[j])
                k++;
            List<List<Integer>> next = new ArrayList<>();
            for (List<Integer> list : current) {
                next.add(list);
                List<Integer> newList = list;
                for (int i = j; i < k; i++) {
                    newList = new ArrayList<>(newList);
                    newList.add(nums[i]);
                    next.add(newList);
                }
            }
            current = next;
            j = k;
        }
        return current;
    }
}