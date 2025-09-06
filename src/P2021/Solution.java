package P2021;

import java.util.Arrays;

class Solution {
    public int brightestPosition(int[][] lights) {
        int max = 0;
        int result = 0;
        int[][] position = new int[lights.length * 2][2];
        int index = 0;
        for (int[] light : lights) {
            int b = light[0] - light[1];
            int e = light[0] + light[1];
            position[index][0] = b;
            position[index][1] = 1;
            index++;
            position[index][0] = e;
            position[index][1] = -1;
            index++;
        }
        Arrays.sort(position, (p1, p2) -> {
            if (p1[0] != p2[0])
                return p1[0] - p2[0];
            return p2[1] - p1[1];
        });
        int current = 0;
        for (int i = 0; i < position.length; i++) {
            current += position[i][1];
            if (position[i][1] == 1 && current > max) {
                max = current;
                result = position[i][0];
            }
        }
        return result;
    }
}
