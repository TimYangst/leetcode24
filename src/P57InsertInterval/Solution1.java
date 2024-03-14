package P57InsertInterval;

class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            assignValue(result[0], newInterval);
            return result;
        }
        int length = intervals.length;
        int[] fb = new int[length + 1];
        int[] fe = new int[length + 1];
        int ft = 0;
        int i = 0;
        while (i < length && intervals[i][1] < newInterval[0]) {
            fb[ft] = intervals[i][0];
            fe[ft] = intervals[i][1];
            i++;
            ft++;
        }

        if (i == length) {
            int[][] result = new int[length + 1][2];
            for (int index = 0; index < length; index++) {
                assignValue(result[index], intervals[index]);
            }
            assignValue(result[length], newInterval);
            return result;
        }

        int[] rb = new int[length + 1];
        int[] re = new int[length + 1];
        int rt = 0;
        int j = length - 1;
        while (j >= 0 && newInterval[1] < intervals[j][0]) {
            rb[rt] = intervals[j][0];
            re[rt] = intervals[j][1];
            j--;
            rt++;
        }
        if (j < 0) {
            int[][] result = new int[length + 1][2];
            assignValue(result[0], newInterval);
            for (int index = 1; index <= length; index++) {
                assignValue(result[index], intervals[index - 1]);
            }
            return result;
        }
        int start = newInterval[0];
        int end = newInterval[1];
        if (intervals[i][0] < start && intervals[i][1] >= start) {
            start = intervals[i][0];
        }
        if (intervals[j][0] <= end && intervals[j][1] > end) {
            end = intervals[j][1];
        }

        int[][] result = new int[ft + rt + 1][2];
        int count = 0;
        for (int k = 0; k < ft; k++) {
            result[count][0] = fb[k];
            result[count][1] = fe[k];
            count++;
        }
        result[count][0] = start;
        result[count][1] = end;
        count++;
        for (int k = rt - 1; k >= 0; k--) {
            result[count][0] = rb[k];
            result[count][1] = re[k];
            count++;
        }
        return result;
    }

    void assignValue(int[] to, int[] from) {
        to[0] = from[0];
        to[1] = from[1];
    }
}