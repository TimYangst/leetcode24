package P215KthLargestElementInAnArray;

import java.util.PriorityQueue;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        int size = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            size++;
            if (size > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}