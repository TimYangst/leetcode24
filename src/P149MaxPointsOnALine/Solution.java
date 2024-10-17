package P149MaxPointsOnALine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean onSameLine(int[] p0, int[] p1, int[] p2) {
        return (p1[0] - p0[0]) * (p2[1] - p0[1]) == (p2[0] - p0[0]) * (p1[1] - p0[1]);
    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2)
            return points.length;
        Arrays.sort(points, (a, b) -> ((a[0] != b[0]) ? (a[0] - b[0]) : (b[1] - a[1])));
        int result = 2;
        for (int i = 0; i < points.length - result; i++) {
            Set<Integer> taken = new HashSet<>();
            for (int j = i + 1; j < points.length; j++) {
                if (!taken.contains(j)) {
                    taken.add(j);
                    int current = 2;
                    for (int k = j + 1; k < points.length; k++) {
                        if (onSameLine(points[i], points[j], points[k])) {
                            taken.add(k);
                            current++;
                        }
                    }
                    if (current > result)
                        result = current;
                }
            }
        }
        return result;
    }
}