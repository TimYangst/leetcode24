package P10RegularExpressionMatching;

class Solution {
    public boolean isMatch(String s, String p) {
        // m[i][j] means whether s[i..] fit for p[j..];
        String np = reform(p);
        boolean[][] m = new boolean[s.length() + 1][np.length() + 1];
        int sl = s.length();
        int pl = np.length();
        for (int i = 0; i <= sl; i++) {
            for (int j = 0; j <= pl; j++) {
                m[i][j] = false;
            }
        }
        m[sl][pl] = true;
        for (int j = pl - 1; j >= 0; j--) {
            if (j == pl - 1) {
                m[sl][j] = false;
            } else {
                if (np.charAt(j + 1) == '*')
                    m[sl][j] = m[sl][j + 2];
            }
        }
        for (int i = sl - 1; i >= 0; i--) {
            for (int j = pl - 1; j >= 0; j--) {
                if (np.charAt(j) == '*') {
                    continue;
                }
                if (j == pl - 1) {
                    m[i][j] = (i == sl - 1 && isMatch(s.charAt(sl - 1), np.charAt(pl - 1)));
                } else {
                    if (isMatch(s.charAt(i), np.charAt(j)) && m[i + 1][j + 1]) {
                        m[i][j] = true;
                        continue;
                    }
                    if (np.charAt(j + 1) == '*') {
                        int k = i;
                        boolean match = m[i][j + 2];
                        while (k < sl && isMatch(s.charAt(k), np.charAt(j))) {
                            match = match || m[k + 1][j + 2];
                            k++;
                        }
                        m[i][j] = match;
                    }
                }
            }
        }
        return m[0][0];
    }

    boolean isMatch(char s, char p) {
        return s == p || p == '.';
    }

    String reform(String p) {
        StringBuilder sb = new StringBuilder();
        boolean star = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (!star) {
                    sb.append('*');
                }
                star = true;
            } else {
                sb.append(p.charAt(i));
                star = false;
            }
        }
        return sb.toString();
    }
}