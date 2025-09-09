package P593;

import java.util.HashSet;
import java.util.Set;

class Solution {
    int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> distSet = new HashSet<>();
        distSet.add(dist(p1, p2));
        distSet.add(dist(p1, p3));
        distSet.add(dist(p1, p4));
        distSet.add(dist(p2, p3));
        distSet.add(dist(p2, p4));
        distSet.add(dist(p3, p4));
        return !distSet.contains(0) && distSet.size() == 2;
    }
}