package P56;

class Solution {

    void sortByEnd(int[][] intervals, int b, int e) {
        if (b >= e)
            return;
        int m = (b + e) / 2;
        int i = b;
        int j = e;
        int[] tmp = new int[2];
        assignValue(tmp, intervals[m]);
        assignValue(intervals[m], intervals[e]);
        while (i < j) {
            while (i < j && cmp(intervals[i], tmp) <= 0) {
                i++;
            }
            if (i < j) {
                assignValue(intervals[j], intervals[i]);
                j--;
            }
            while (i < j && cmp(intervals[j], tmp) >= 0) {
                j--;
            }
            if (i < j) {
                assignValue(intervals[i], intervals[j]);
                i++;
            }
        }
        assignValue(intervals[i], tmp);
        if (b < i - 1) {
            sortByEnd(intervals, b, i - 1);
        }
        if (i + 1 < e) {
            sortByEnd(intervals, i + 1, e);
        }
    }

    int cmp(int[] a, int[] b) {
        if (a[1] != b[1])
            return a[1] - b[1];
        return a[0] - b[0];
    }

    void assignValue(int[] to, int[] from) {
        to[0] = from[0];
        to[1] = from[1];
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        sortByEnd(intervals, 0, intervals.length - 1);
        int total = 0;
        int[] b = new int[intervals.length];
        int[] e = new int[intervals.length];
        int i = intervals.length - 1;
        b[total] = intervals[i][0];
        e[total] = intervals[i][1];
        i--;
        while (i >= 0) {
            if (intervals[i][1] < b[total]) {
                total++;
                b[total] = intervals[i][0];
                e[total] = intervals[i][1];
            } else {
                b[total] = Math.min(intervals[i][0], b[total]);
            }
            i--;
        }
        int[][] result = new int[total + 1][2];
        for (int j = 0; j <= total; j++) {
            result[j][0] = b[total - j];
            result[j][1] = e[total - j];
        }
        return result;
    }
}