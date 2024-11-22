package P647;

class Solution {
    public int countSubstrings(String s) {
        if (s.length() <= 1)
            return s.length();
        int[][] f = new int[s.length()][s.length()];
        boolean[][] p = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            f[i][i] = 1;
            p[i][i] = true;
            if (i != s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    f[i][i + 1] = 3;
                    p[i][i + 1] = true;
                } else {
                    f[i][i + 1] = 2;
                    p[i][i + 1] = false;
                }
            }
        }
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                p[i][i + l] = (s.charAt(i) == s.charAt(i + l)) && p[i + 1][i + l - 1];
                if (p[i][i + l]) {
                    f[i][i + l] += 1;
                }
                f[i][i + l] += f[i][i + l - 1];
                f[i][i + l] += f[i + 1][i + l];
                f[i][i + l] -= f[i + 1][i + l - 1];
            }
        }
        return f[0][s.length() - 1];
    }
}