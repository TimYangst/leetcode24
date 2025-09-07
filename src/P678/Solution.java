package P678;

class Solution {
    public boolean checkValidString(String s) {
        if (s.length() == 0)
            return true;

        int[][] status = new int[s.length() + 1][s.length() + 1];
        return search(s, 0, s.length() - 1, status);
    }

    boolean search(String s, int b, int e, int[][] status) {
        if (b > e)
            return true;
        if (status[b][e] != 0)
            return status[b][e] == 1;
        if (b == e) {
            status[b][e] = (s.charAt(b) == '*' ? 1 : -1);
            return status[b][e] == 1;
        }
        if (b + 1 == e) {
            if ((s.charAt(b) == '(' || s.charAt(b) == '*')
                    && (s.charAt(e) == ')' || s.charAt(e) == '*')) {
                status[b][e] = 1;
            } else
                status[b][e] = -1;
            return status[b][e] == 1;
        }
        if (s.charAt(b) == '*') {
            if (search(s, b + 1, e, status)) {
                status[b][e] = 1;
                return true;
            }
        }
        if (s.charAt(e) == '*') {
            if (search(s, b, e - 1, status)) {
                status[b][e] = 1;
                return true;
            }
        }
        if ((s.charAt(b) == '(' || s.charAt(b) == '*')
                && (s.charAt(e) == ')' || s.charAt(e) == '*')) {
            if (search(s, b + 1, e - 1, status)) {
                status[b][e] = 1;
                return true;
            }
        }
        for (int i = b; i < e; i++) {
            if (search(s, b, i, status) && search(s, i + 1, e, status)) {
                status[b][e] = 1;
                return true;
            }
        }
        status[b][e] = -1;
        return false;
    }
}