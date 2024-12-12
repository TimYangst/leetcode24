package P1272;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] <= toBeRemoved[0]) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
            i++;
        }
        if (i < intervals.length && intervals[i][0] < toBeRemoved[0]) {
            result.add(List.of(intervals[i][0], toBeRemoved[0]));
        }
        while (i < intervals.length && intervals[i][1] <= toBeRemoved[1]) {
            i++;
        }
        if (i < intervals.length && intervals[i][0] < toBeRemoved[1]) {
            result.add(List.of(toBeRemoved[1], intervals[i][1]));
            i++;
        }
        while (i < intervals.length) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
            i++;
        }
        return result;
    }
}
