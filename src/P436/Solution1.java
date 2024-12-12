package P436;

import java.util.TreeMap;

class Solution1 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> startIndexing = new TreeMap<>();
        for (int i = 0 ; i < intervals.length; i++) {
            startIndexing.put(intervals[i][0], i);
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i< intervals.length; i++) {
            Integer key = startIndexing.ceilingKey(intervals[i][1]);
            result[i] = (key == null)? -1 : startIndexing.get(key);
        }
        return result;
    }
}