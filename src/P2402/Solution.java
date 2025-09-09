package P2402;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        PriorityQueue<Long> nextTime = new PriorityQueue<>((a, b) -> a > b ? 1 : -1);
        for (int i = 0; i < meetings.length; i++) {
            nextTime.add((long) meetings[i][0]);
        }
        PriorityQueue<long[]> ending = new PriorityQueue<>((a, b) -> a[0] > b[0] ? 1 : -1);
        int[] count = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Queue<Integer> waiting = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        int index = 0;
        while (!nextTime.isEmpty() && (index < meetings.length || !waiting.isEmpty())) {
            long start = nextTime.poll();
            while (!ending.isEmpty() && ending.peek()[0] <= start) {
                long[] ended = ending.poll();
                pq.add((int) ended[1]);
            }
            while (!waiting.isEmpty() && !pq.isEmpty()) {
                int picked = pq.poll();
                int mt = waiting.poll();
                count[picked]++;
                ending.add(new long[] { start + (meetings[mt][1] - meetings[mt][0]), picked });
                nextTime.add(start + (meetings[mt][1] - meetings[mt][0]));
            }
            while (index < meetings.length && meetings[index][0] <= start) {
                if (pq.isEmpty()) {
                    waiting.add(index);
                } else {
                    int picked = pq.poll();
                    count[picked]++;
                    ending.add(new long[] { meetings[index][1], picked });
                    nextTime.add((long) meetings[index][1]);
                }
                index++;
            }
        }
        int result = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                result = i;
            }
        }
        return result;
    }
}