package P1762;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findBuildings(int[] heights) {
        if (heights.length == 0)
            return new int[0];
        List<Integer> indexs = new ArrayList<>();
        int currentHigh = heights[heights.length - 1];
        indexs.add(heights.length - 1);
        for (int j = heights.length - 2; j >= 0; j--) {
            if (heights[j] > currentHigh) {
                currentHigh = heights[j];
                indexs.add(j);
            }
        }
        int[] result = new int[indexs.size()];
        int i = result.length - 1;
        for (int k : indexs) {
            result[i--] = k;
        }
        return result;
    }
}