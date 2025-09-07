package P678;

class Solution2 {
    public boolean checkValidString(String s) {
        if (s.length() == 0) return true;
        boolean[][] status = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            status[i][i] = (s.charAt(i) == '*');
            if (i < s.length() -1) {
                status[i][i+1] = ( (s.charAt(i) == '(' || s.charAt(i) == '*') 
                    && (s.charAt(i+1) == ')' || s.charAt(i+1) == '*'));
            }
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = i + l - 1;
                if (status[i+1][j-1] &&  (s.charAt(i) == '(' || s.charAt(i) == '*') 
                    && (s.charAt(j) == ')' || s.charAt(j) == '*')) {
                    status[i][j] = true;
                    continue;
                }
                if ((s.charAt(i) == '*' && status[i+1][j])
                    || (s.charAt(j) == '*' && status[i][j-1])) {
                    status[i][j] = true;
                    continue;
                }
                for (int k = i; k <j; k ++) {
                    if (status[i][k] && status[k+1][j]) {
                        status[i][j]= true;
                        break;
                    }
                }
            }
        }
        return status[0][s.length()-1];
    }
}