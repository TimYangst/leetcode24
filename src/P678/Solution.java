package P678;

class Solution {
    public boolean checkValidString(String s) {
        if (s.length() == 0)
            return true;
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    low++;
                    high++;
                    break;
                case ')':
                    low = Math.max(0, low - 1);
                    high--;
                    if (high < 0)
                        return false;
                    break;
                case '*':
                    low = Math.max(0, low - 1);
                    high++;
                    break;
                default:
            }
        }
        return low == 0;
    }
}