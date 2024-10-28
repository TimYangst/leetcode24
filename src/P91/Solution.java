package P91;

class Solution {

    boolean isValidTwoCombine(String s, int i) {
        if (s.charAt(i) == '1')
            return true;
        if (s.charAt(i) == '2' && '0' <= s.charAt(i + 1) && '6' >= s.charAt(i + 1))
            return true;
        return false;
    }

    public int numDecodings(String s) {
        if (s.length() <= 0)
            return 1;
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = (s.charAt(0) == '0') ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0')
                f[i] = f[i - 1];
            if (isValidTwoCombine(s, i - 2))
                f[i] += f[i - 2];
        }
        return f[s.length()];
    }
}
