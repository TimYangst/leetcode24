package Top150.P128LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] parent = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            parent[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], i);
                insert(nums[i], indexMap, parent, count);
            }
        }
        int result = 1;
        for (int i = 0; i < nums.length; i++)
            result = Math.max(result, count[i]);
        return result;
    }

    void insert(int n, Map<Integer, Integer> indexMap, int[] parent, int[] count) {
        int current = indexMap.get(n);
        int index;
        if (indexMap.containsKey(n - 1)) {
            index = indexMap.get(n - 1);
            merge(current, index, parent, count);
        }
        if (indexMap.containsKey(n + 1)) {
            index = indexMap.get(n + 1);
            merge(current, index, parent, count);
        }
    }

    int getParent(int index, int[] parent) {
        if (parent[index] != index) {
            parent[index] = getParent(parent[index], parent);
        }
        return parent[index];
    }

    void merge(int i1, int i2, int[] parent, int[] count) {
        int p1 = getParent(i1, parent);
        int p2 = getParent(i2, parent);
        if (p1 == p2)
            return;
        if (count[p1] >= count[p2]) {
            parent[p2] = p1;
            parent[i2] = p1;
            count[p1] += count[p2];
        } else {
            parent[p1] = p2;
            parent[i1] = p2;
            count[p2] += count[p1];
        }
    }
}