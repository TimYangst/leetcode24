package P593;

class Solution1 {
    int dist(int[] p0, int[] p1) {
        return (p1[0]-p0[0])* (p1[0]-p0[0])+(p1[1]-p0[1])*(p1[1]-p0[1]);
    }

    boolean is90D(int[] p0 , int[] p1, int[] p2) {
        System.out.println((p2[1] - p0[1]) * (p1[0] - p0[0]) + (p2[0] - p0[0])*(p1[1] - p0[1]));
        return (p2[1] - p0[1]) * (p1[1] - p0[1]) + (p2[0] - p0[0])*(p1[0] - p0[0]) == 0;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1 = dist(p1, p2);
        int d2 = dist(p1, p3);
        if (d1 == 0 || d2 ==0) return false;
        if (d1 > d2) {
            int[] tmp = p2;
            p2 = p4;
            p4 = tmp;
        } else if (d1 < d2) {
            int[] tmp = p3;
            p3 = p4;
            p4 = tmp;
        }
        d1 = dist(p1, p2);
        d2 = dist(p1, p3);
        if (d1 != d2) return false;
        int d3 = dist(p1, p4);
        System.out.println(d3);
        if (d3 != 2 * d1) return false;
        if(!is90D(p1, p2, p3) || !is90D(p4, p2, p3)) return false;
        return true;
    }
}
