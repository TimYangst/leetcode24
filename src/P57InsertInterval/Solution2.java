package P57InsertInterval;

class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            assignValue(result[0], newInterval);
            return result;
        }
        int b = binarySearch(intervals, 0, intervals.length, newInterval[0]);
        int e = binarySearch(intervals, 0, intervals.length, newInterval[1]);
        int total = 0;
        int[] start = new int[intervals.length + 1];
        int[] end = new int[intervals.length + 1];
        for (int i = 0; i < b; i++) {
            start[total] = intervals[i][0];
            end[total] = intervals[i][1];
            total++;
        }
        if (b == intervals.length) {
            start[total] = newInterval[0];
            end[total] = newInterval[1];
            total++;
        } else {
            start[total] = Math.min(intervals[b][0], newInterval[0]);
            int next = e;
            if (next == intervals.length) {
                end[total] = newInterval[1];
                total++;
            } else {
                if (newInterval[1] < intervals[next][0]) {
                    end[total] = newInterval[1];
                } else {
                    end[total] = intervals[next][1];
                    next++;
                }
                total++;
                for (int i = next; i < intervals.length; i++) {
                    start[total] = intervals[i][0];
                    end[total] = intervals[i][1];
                    total++;
                }
            }
        }
        int[][] result = new int[total][2];
        for (int k = 0; k < total; k++) {
            result[k][0] = start[k];
            result[k][1] = end[k];
        }
        return result;
    }

    int binarySearch(int[][] intervals, int b, int e, int value) {
        if (b == e)
            return b;
        if (b + 1 == e) {
            if (intervals[b][1] < value)
                return e;
            return b;
        }
        int m = (b + e) / 2;
        if (value < intervals[m][0]) {
            return binarySearch(intervals, b, m, value);
        } else {
            return binarySearch(intervals, m, e, value);
        }
    }

    void assignValue(int[] to, int[] from) {
        to[0] = from[0];
        to[1] = from[1];
    }
}