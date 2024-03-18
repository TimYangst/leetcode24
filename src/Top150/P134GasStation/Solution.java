package Top150.P134GasStation;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l = gas.length;
        int totalDebts = 0;
        int currentBalance = 0;
        int offset = 0;
        int i = 0;
        while (i < l) {
            if (currentBalance + gas[i] - cost[i] < 0) {
                totalDebts += currentBalance + gas[i] - cost[i];
                i++;
                offset = i;
                currentBalance = 0;
            } else {
                currentBalance = currentBalance + gas[i] - cost[i];
                i++;
            }
        }
        if (currentBalance + totalDebts >= 0)
            return offset;
        return -1;
    }
}