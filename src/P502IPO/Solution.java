package P502IPO;

import java.util.PriorityQueue;

class Project {
    int capital;
    int profit;

    public Project(int profit, int capital) {
        this.capital = capital;
        this.profit = profit;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<Project>((a, b) -> (a.capital - b.capital));
        PriorityQueue<Project> availableProject = new PriorityQueue<Project>((a, b) -> (b.profit - a.profit));
        int picked = 0;
        int currentCapital = w;
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.add(new Project(profits[i], capital[i]));
        }
        while (picked < k) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= currentCapital) {
                availableProject.add(minCapitalHeap.poll());
            }
            if (availableProject.isEmpty())
                break;
            Project current = availableProject.poll();
            currentCapital += current.profit;
            picked++;
        }
        return currentCapital;
    }
}