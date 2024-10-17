package P149MaxPointsOnALine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int gcd(int a, int b) {
        if (b == 0 || a == 0)
            return 0;
        if (b % a == 0)
            return a;
        return gcd(b % a, a);
    }

    private String getSlopeTag(int[] p0, int[] p1) {
        int gcd = gcd(p1[1] - p0[1], p1[0] - p0[0]);
        if (gcd == 0)
            return "0";
        return String.format("%s/%s", (p1[1] - p0[1]) / gcd, (p1[0] - p0[0]) / gcd);
    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2)
            return points.length;
        Arrays.sort(points, (a, b) -> ((a[0] != b[0]) ? (a[0] - b[0]) : (b[1] - a[1])));
        int result = 2;
        for (int i = 0; i + result < points.length; i++) {
            int count = 0;
            int j = i;
            while (j < points.length && points[j][0] == points[i][0]) {
                j++;
                count++;
            }
            if (count > result)
                result = count;
            Map<String, Integer> countMap = new HashMap<>();
            for (int k = j; k < points.length; k++) {
                countMap.compute(getSlopeTag(points[i], points[k]),
                        (key, value) -> (value == null ? 2 : value + 1));
            }
            for (int value : countMap.values()) {
                if (value > result)
                    result = value;
            }
        }
        return result;
    }
}
