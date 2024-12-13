package P207CourseSchedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1)
            return true;
        Map<Integer, Set<Integer>> coursePres = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (coursePres.containsKey(a)) {
                coursePres.get(a).add(b);
            } else {
                Set<Integer> preS = new HashSet<>();
                preS.add(b);
                coursePres.put(a, preS);
            }
        }
        int taken = 0;
        Queue<Integer> courses = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!coursePres.containsKey(i)) {
                taken++;
                courses.add(i);
            }
        }
        while (taken < numCourses && !courses.isEmpty()) {
            int current = courses.poll();
            for (int i = 0; i < numCourses; i++) {
                if (coursePres.containsKey(i)) {
                    Set<Integer> preS = coursePres.get(i);
                    if (preS.contains(current)) {
                        preS.remove(current);
                        if (preS.isEmpty()) {
                            taken++;
                            courses.add(i);
                            if (taken == numCourses)
                                break;
                        }
                    }
                }
            }
        }
        return taken == numCourses;
    }
}