package P2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int brightestPosition(int[][] lights) {
        int max = 0;
        int result = 0;
        List<int[]> position = new ArrayList<>();

        for (int[] light : lights) {
            position.add(new int[] { light[0] - light[1], 1 });
            position.add(new int[] { light[0] + light[1], -1 });
        }
        Collections.sort(position, (p1, p2) -> (p1[0] != p2[0]) ? p1[0] - p2[0] : p2[1] - p1[1]);
        int current = 0;
        for (int[] point : position) {
            current += point[1];
            if (current > max) {
                max = current;
                result = point[0];
            }
        }
        return result;
    }
}