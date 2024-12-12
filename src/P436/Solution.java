package P436;

import java.util.Arrays;

class Interval {
    int index;
    int[] interval;

    public Interval(int index, int[] interval) {
        this.index = index;
        this.interval = interval;
    }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Interval[] sortByStart = new Interval[intervals.length];
        Interval[] sortByEnd = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            sortByStart[i] = sortByEnd[i] = new Interval(i, intervals[i]);
        }
        ;
        Arrays.sort(sortByStart, (a, b) -> (a.interval[0] - b.interval[0]));
        Arrays.sort(sortByEnd, (a, b) -> (b.interval[1] - a.interval[1]));
        int j = intervals.length - 1;
        int i = 0;
        while (i < intervals.length) {
            result[sortByEnd[i].index] = -1;
            while (j > 0 && sortByStart[j - 1].interval[0] >= sortByEnd[i].interval[1])
                j--;
            if (sortByStart[j].interval[0] >= sortByEnd[i].interval[1])
                result[sortByEnd[i].index] = sortByStart[j].index;
            i++;
        }
        return result;
    }
}
