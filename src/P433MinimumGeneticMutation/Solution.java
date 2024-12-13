package P433MinimumGeneticMutation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return 0;
        if (bank.length == 0)
            return -1;
        Map<String, Integer> banks = new HashMap<>();
        banks.put(startGene, 0);
        int total = 1;
        for (int i = 0; i < bank.length; i++) {
            if (!banks.containsKey(bank[i])) {
                banks.put(bank[i], total);
                total++;
            }
        }
        if (!banks.containsKey(endGene))
            return -1;
        boolean[][] connection = new boolean[total][total];
        for (String gene : banks.keySet()) {
            for (String other : banks.keySet()) {
                if (isConnect(gene, other)) {
                    int i = banks.get(gene);
                    int j = banks.get(other);
                    connection[i][j] = true;
                    connection[j][i] = true;
                }
            }
        }
        int[] steps = new int[total];
        for (int i = 1; i < total; i++) {
            steps[i] = -1;
        }
        int end = banks.get(endGene);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty() && steps[end] == -1) {
            int current = queue.poll();
            for (int i = 1; i < total; i++) {
                if (steps[i] == -1 && connection[current][i]) {
                    steps[i] = steps[current] + 1;
                    queue.add(i);
                }
            }
        }
        return steps[end];
    }

    boolean isConnect(String a, String b) {
        int l = a.length();
        int diff = 0;
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}