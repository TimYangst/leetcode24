package P2402;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
        for (int i = 0; i < meetings.length; i++) {
            int current = meetings[i][0];
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= current) {
                long[] ended = occupiedRooms.poll();
                availableRooms.add((int) ended[1]);
            }
            if (!availableRooms.isEmpty()) {
                int picked = availableRooms.poll();
                long[] occupied = new long[2];
                occupied[0] = meetings[i][1];
                occupied[1] = picked;
                occupiedRooms.add(occupied);
                count[picked]++;
            } else {
                long[] earliest = occupiedRooms.poll();
                count[(int) earliest[1]]++;
                earliest[0] += (long) (meetings[i][1] - meetings[i][0]);
                occupiedRooms.add(earliest);
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