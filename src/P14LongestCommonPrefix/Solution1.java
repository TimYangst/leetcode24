package P14LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        return cmp(strs, 0, strs.length - 1, strs[0].length());
    }

    String cmp(String[] strs, int b, int e, int minL) {
        if (b == e)
            return strs[b];
        if (b + 1 == e)
            return commonPrefix(strs[b], strs[e], minL);
        int m = (b + e) / 2;
        String lr = cmp(strs, b, m, minL);
        minL = Math.min(minL, lr.length());
        String rr = cmp(strs, m + 1, e, minL);
        return commonPrefix(lr, rr, minL);
    }

    String commonPrefix(String s1, String s2, int minL) {
        StringBuilder sb = new StringBuilder();
        int l = Math.min(Math.min(s1.length(), s2.length()), minL);
        for (int i = 0; i < l; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            } else
                break;
        }
        return sb.toString();
    }
}
