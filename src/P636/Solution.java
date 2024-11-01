package P636;

import java.util.List;
import java.util.Stack;

class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] runTime = new int[n];
        int lastRunPoint = 0;
        for (String log : logs) {
            String[] data = log.split(":");
            int task = Integer.valueOf(data[0]);
            int time = Integer.valueOf(data[2]);
            if ("start".equals(data[1])) {
                if (!stack.isEmpty()) {
                    runTime[stack.peek()] += time - lastRunPoint;
                }
                stack.push(task);
                lastRunPoint = time;
            } else {
                runTime[stack.pop()] += time - lastRunPoint + 1;
                lastRunPoint = time + 1;
            }
        }
        return runTime;

    }
}
