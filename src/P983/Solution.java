package P983;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0)
            return 0;
        int[] f = new int[days.length + 1];
        f[1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = 1; i < days.length; i++) {
            f[i + 1] = f[i] + costs[0];
            int j = i - 1;
            while (j >= 0 && days[j] > days[i] - 7)
                j--;
            f[i + 1] = Math.min(f[i + 1], f[j + 1] + costs[1]);
            while (j >= 0 && days[j] > days[i] - 30)
                j--;
            f[i + 1] = Math.min(f[i + 1], f[j + 1] + costs[2]);
        }
        return f[days.length];
    }
}