package P815BusRoutes;

import java.util.Arrays;

class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        int maxStop = 0;
        for (int[] route : routes) {
            for (int stop : route) {
                maxStop = Math.max(maxStop, stop);
            }
        }
        if (maxStop < target || maxStop < source)
            return -1;
        int[] minStepToReach = new int[maxStop + 1];
        Arrays.fill(minStepToReach, routes.length + 1);
        minStepToReach[source] = 0;
        boolean updated = true;
        while (updated) {
            updated = false;
            for (int[] route : routes) {
                int minStep = routes.length + 1;
                for (int stop : route) {
                    minStep = Math.min(minStepToReach[stop], minStep);
                }
                for (int stop : route) {
                    if (minStepToReach[stop] > minStep + 1) {
                        updated = true;
                        minStepToReach[stop] = minStep + 1;
                    }
                }
            }
        }
        if (minStepToReach[target] <= routes.length)
            return minStepToReach[target];
        return -1;
    }
}