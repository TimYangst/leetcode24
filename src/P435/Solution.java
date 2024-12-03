package P435;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        if (intervals.length <= 1)
            return 0;
        int currentEnd = intervals[0][1];
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currentEnd) {
                currentEnd = intervals[i][1];
            } else {
                result++;
            }
        }
        return result;
    }
}