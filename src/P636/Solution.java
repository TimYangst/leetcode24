package P636;

import java.util.List;
import java.util.Stack;

class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] runTime = new int[n];
        int lastStart = 0;
        int lastEnd = -1;
        for (String log : logs) {
            String[] data = log.split(":");
            int task = Integer.valueOf(data[0]);
            int time = Integer.valueOf(data[2]);

            if ("start".equals(data[1])) {
                if (!stack.isEmpty()) {
                    if (lastStart > lastEnd) {
                        runTime[stack.peek()] += time - lastStart;
                    } else {
                        runTime[stack.peek()] += time - lastEnd - 1;
                    }
                }
                stack.push(task);
                lastStart = time;
            } else {
                if (lastStart > lastEnd) {
                    runTime[stack.pop()] += time - lastStart + 1;
                } else {
                    runTime[stack.pop()] += time - lastEnd;
                }
                lastEnd = time;
            }
        }
        return runTime;

    }
}
