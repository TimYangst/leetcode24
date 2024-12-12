package P57InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        int[] toAdd = Arrays.copyOf(newInterval, 2);
        while (i < intervals.length && intervals[i][0] <= toAdd[1]) {
            toAdd[0] = Math.min(toAdd[0], intervals[i][0]);
            toAdd[1] = Math.max(toAdd[1], intervals[i][1]);
            i++;
        }
        result.add(toAdd);
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
