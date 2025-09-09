package P179;

import java.util.PriorityQueue;

class Solution {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            pq.add(String.valueOf(num));
        }
        if (!pq.isEmpty() && pq.peek().equals("0"))
            return "0";
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}