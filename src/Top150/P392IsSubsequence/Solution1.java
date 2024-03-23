package Top150.P392IsSubsequence;

class Solution1 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;
        if (s.length() > t.length())
            return false;
        boolean[][] f = new boolean[s.length() + 1][t.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= t.length(); i++) {
            f[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                }
                f[i][j] = f[i][j] || f[i][j - 1];
            }
        }
        return f[s.length()][t.length()];
    }
}