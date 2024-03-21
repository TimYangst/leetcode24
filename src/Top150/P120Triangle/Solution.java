package Top150.P120Triangle;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0)
            return 0;
        int[] current = new int[n];
        int[] result = new int[n];
        result[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                current[j] = result[j];
            result[0] = current[0] + triangle.get(i).get(0);
            result[i] = current[i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                result[j] = Math.min(current[j], current[j - 1]) + triangle.get(i).get(j);
            }
        }
        int r = result[0];
        for (int j = 1; j < n; j++) {
            r = Math.min(r, result[j]);
        }
        return r;
    }
}
