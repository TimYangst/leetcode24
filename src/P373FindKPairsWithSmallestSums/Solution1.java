package P373FindKPairsWithSmallestSums;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int value1;
    int value2;
    int sum;

    Pair(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
        this.sum = value1 + value2;
    }
}

class Solution1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> (b.sum - a.sum));
        for (int i1 = 0; i1 < l1; i1++) {
            for (int i2 = 0; i2 < l2; i2++) {
                if (heap.size() == k && heap.peek().sum <= (nums1[i1] + nums2[i2]))
                    break;
                heap.add(new Pair(nums1[i1], nums2[i2]));
                if (heap.size() > k)
                    heap.poll();
            }
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            Pair current = heap.poll();
            result.addFirst(List.of(current.value1, current.value2));
        }
        return result;
    }
}