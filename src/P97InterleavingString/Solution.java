package P97InterleavingString;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0)
            return s3.equals(s2);
        if (s2.length() == 0)
            return s3.equals(s1);
        if (s3.length() != (s1.length() + s2.length()))
            return false;
        boolean f[][] = new boolean[s1.length() + 1][s2.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                f[i][0] = f[i - 1][0];
            if (f[i][0] == false)
                break;
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1))
                f[0][j] = f[0][j - 1];
            if (f[0][j] == false)
                break;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c = s3.charAt(i + j - 1);
                if (c == s1.charAt(i - 1))
                    f[i][j] |= f[i - 1][j];
                if (c == s2.charAt(j - 1))
                    f[i][j] |= f[i][j - 1];
            }
        }
        return f[s1.length()][s2.length()];
    }
}