package P44WildcardMatching;

class Solution1 {
    public boolean isMatch(String s, String p) {
        boolean m[][] = new boolean[s.length() + 1][p.length() + 1];
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (p.length() == 0)
            return false;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                m[i][j] = false;
            }
        }
        m[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            m[0][i] = m[0][i - 1] && p.charAt(i - 1) == '*';
        }

        if (p.charAt(0) == '*') {
            for (int i = 0; i <= s.length(); i++) {
                m[i][1] = true;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sC = s.charAt(i - 1);
                char pC = p.charAt(j - 1);
                if (pC == '*') {
                    for (int k = 0; k <= i; k++) {
                        if (m[k][j] || m[k][j - 1]) {
                            m[i][j] = true;
                            break;
                        }
                    }
                } else if (pC == sC || pC == '?') {
                    m[i][j] = m[i - 1][j - 1];
                }
            }
        }
        return m[s.length()][p.length()];
    }
}
