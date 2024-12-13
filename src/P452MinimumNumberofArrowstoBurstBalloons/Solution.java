package P452MinimumNumberofArrowstoBurstBalloons;

class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1)
            return points.length;
        sortByEnd(points, 0, points.length - 1);
        int result = 0;
        int lastPosition = 0;
        int i = 0;
        while (i < points.length) {
            if (result == 0 || points[i][0] > lastPosition) {
                result++;
                lastPosition = points[i][1];
            }
            i++;
        }
        return result;
    }

    void sortByEnd(int[][] points, int b, int e) {
        if (b == e)
            return;
        int[] tmp = new int[2];
        int m = ((b + e) >> 1);
        assign(tmp, points[m]);
        assign(points[m], points[e]);
        int i = b;
        int j = e;
        while (i < j) {
            while (i < j && cmp(points[i], tmp) <= 0)
                i++;
            if (i < j) {
                assign(points[j], points[i]);
                j--;
            }
            while (i < j && cmp(points[j], tmp) >= 0)
                j--;
            if (i < j) {
                assign(points[i], points[j]);
                i++;
            }
        }
        assign(points[i], tmp);
        if (b < i - 1)
            sortByEnd(points, b, i - 1);
        if (i + 1 < e)
            sortByEnd(points, i + 1, e);
    }

    void assign(int to[], int[] from) {
        to[0] = from[0];
        to[1] = from[1];
    }

    int cmp(int p1[], int p2[]) {
        if (p1[1] != p2[1]) {
            if (p1[1] < p2[1])
                return -1;
            return 1;
        }
        if (p1[0] < p2[0])
            return -1;
        if (p1[0] > p2[0])
            return 1;
        return 0;
    }
}