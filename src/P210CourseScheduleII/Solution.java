package P210CourseScheduleII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        } else if (numCourses == 1) {
            return new int[1];
        }
        Map<Integer, Set<Integer>> precourses = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (precourses.containsKey(a)) {
                precourses.get(a).add(b);
            } else {
                Set<Integer> preS = new HashSet<>();
                preS.add(b);
                precourses.put(a, preS);
            }
        }
        Queue<Integer> taken = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!precourses.containsKey(i)) {
                taken.add(i);
                result.add(i);
            }
        }
        while (!taken.isEmpty() && result.size() < numCourses) {
            int current = taken.poll();
            for (int i = 0; i < numCourses; i++) {
                if (precourses.containsKey(i)) {
                    Set<Integer> preS = precourses.get(i);
                    if (preS.contains(current)) {
                        preS.remove(current);
                        if (preS.isEmpty()) {
                            precourses.remove(i);
                            result.add(i);
                            taken.add(i);
                            if (result.size() == numCourses)
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == numCourses) {
            int[] r = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                r[i] = result.get(i);
            }
            return r;
        }
        return new int[0];
    }
}
