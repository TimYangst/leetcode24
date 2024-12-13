package P392IsSubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;
        if (s.length() > t.length())
            return false;
        int i = 0;
        int j = 0;
        int ls = s.length();
        int lt = t.length();
        while (i < ls && j < lt) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == ls;
    }
}