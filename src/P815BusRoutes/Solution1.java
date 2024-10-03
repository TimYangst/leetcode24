package P815BusRoutes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Stop {
    int id;
    int step;

    public Stop(int id, int step) {
        this.id = id;
        this.step = step;
    }
}

class Solution1 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        Map<Integer, Set<Integer>> stopRoutes = new HashMap<>();
        for (int routeId = 0; routeId < routes.length; routeId++) {
            for (int i = 0; i < routes[routeId].length; i++) {
                stopRoutes.computeIfAbsent(routes[routeId][i], key -> new HashSet<>());
                stopRoutes.get(routes[routeId][i]).add(routeId);
            }
        }
        if (!stopRoutes.containsKey(source) || !stopRoutes.containsKey(target))
            return -1;
        Set<Integer> visited = new HashSet<>();
        Queue<Stop> queue = new LinkedList<>();
        visited.add(source);
        queue.add(new Stop(source, 0));
        while (!queue.isEmpty() && !visited.contains(target)) {
            Stop current = queue.poll();
            for (int routeId : stopRoutes.get(current.id)) {
                for (int next : routes[routeId]) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        if (next == target) {
                            return current.step + 1;
                        }
                        queue.add(new Stop(next, current.step + 1));
                    }
                }
            }
        }

        return -1;
    }
}