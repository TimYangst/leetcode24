package P253;

import java.util.Arrays;

class Pair {
    int time;
    boolean isStart;

    public Pair(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals.length;
        Pair[] array = new Pair[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            array[i * 2] = new Pair(intervals[i][0], true);
            array[i * 2 + 1] = new Pair(intervals[i][1], false);
        }
        Arrays.sort(array, (a, b) -> {
            if (a.time != b.time)
                return a.time - b.time;
            else if (a.isStart == b.isStart)
                return 0;
            if (a.isStart)
                return 1;
            return -1;
        });
        int result = 0;
        int count = 0;

        for (Pair pair : array) {
            if (pair.isStart)
                count++;
            else
                count--;
            result = Math.max(result, count);
        }
        return result;
    }
}