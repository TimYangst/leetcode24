package P218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings.length == 0)
            return result;
        int[][] points = new int[buildings.length * 2][2];
        int n = 0;
        for (int[] interval : buildings) {
            points[n][0] = interval[0]; // axis
            points[n][1] = -interval[2]; // height
            n++;
            points[n][0] = interval[1]; // axis
            points[n][1] = interval[2]; // height
            n++;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];

        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int prev = 0;
        pq.offer(0);
        for (int[] point : points) {
            if (point[1] < 0) {
                pq.offer(-point[1]);
            } else {
                pq.remove(point[1]);
            }
            int current = pq.peek();
            if (prev != current) {
                result.add(List.of(point[0], current));
                prev = current;
            }
        }
        return result;
    }
}
