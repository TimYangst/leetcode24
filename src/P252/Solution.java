package P252;

import java.util.Arrays;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1)
            return true;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });
        int current = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < current)
                return false;
            current = Math.max(current, intervals[i][1]);
        }
        return true;
    }
}