package P839;

class Solution {

    private int[] parent;
    private int[] weight;

    private int findRoot(int i) {
        if (parent[i] == i)
            return i;
        int root = findRoot(parent[i]);
        parent[i] = root;
        return root;
    }

    private void merge(int i, int j) {
        int ri = findRoot(i);
        int rj = findRoot(j);
        if (weight[ri] < weight[rj]) {
            parent[ri] = rj;
            weight[rj] += weight[ri];
        } else {
            parent[rj] = ri;
            weight[ri] += weight[rj];
        }
    }

    private boolean isSimilar(String s, String t) {
        if (s.length() != t.length())
            return false;
        int diff = 0;
        int[] d = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (diff == 2)
                    return false;
                d[diff++] = i;
            }
        }
        return diff == 0 || (diff == 2 && s.charAt(d[0]) == t.charAt(d[1])
                && s.charAt(d[1]) == t.charAt(d[0]));
    }

    public int numSimilarGroups(String[] strs) {
        if (strs.length <= 1)
            return strs.length;
        parent = new int[strs.length];
        weight = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (findRoot(i) != findRoot(j) && isSimilar(strs[i], strs[j])) {
                    merge(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < strs.length; i++) {
            if (parent[i] == i)
                result++;
        }
        return result;
    }
}