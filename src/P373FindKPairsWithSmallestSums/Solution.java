package P373FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        // Pairs of sum and index of second element in nums2;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < l1; i++) {
            heap.offer(new int[] { nums1[i] + nums2[0], 0 });
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k > 0 && !heap.isEmpty()) {
            int[] current = heap.poll();
            result.add(List.of(current[0] - nums2[current[1]], nums2[current[1]]));
            if (current[1] + 1 < l2) {
                heap.offer(new int[] {
                        current[0] - nums2[current[1]] + nums2[current[1] + 1],
                        current[1] + 1 });
            }
            k--;
        }
        return result;
    }
}