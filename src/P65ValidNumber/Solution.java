package P65ValidNumber;

class Solution {
    public boolean isNumber(String s) {
        if (s.isEmpty())
            return false;
        int l = s.length();
        int eIndex = getEIndex(s);
        if (eIndex == -1) {
            return isValidPureDecimal(s, 0, l - 1);
        } else {
            return isValidPureDecimal(s, 0, eIndex - 1) && isValidInteger(s, eIndex + 1, l - 1);
        }
    }

    public boolean isValidPureDecimal(String s, int b, int e) {
        if (b > e)
            return false;
        if (s.charAt(b) == '-' || s.charAt(b) == '+')
            b++;
        if (b > e)
            return false;
        if (b == e)
            return isDigit(s.charAt(b));
        int dotCount = 0;
        for (int i = b; i <= e; i++) {
            if (s.charAt(i) == '.')
                dotCount++;
            else if (!isDigit(s.charAt(i)))
                return false;
        }
        return dotCount <= 1;
    }

    public boolean isValidInteger(String s, int b, int e) {
        if (b > e)
            return false;
        if (s.charAt(b) == '-' || s.charAt(b) == '+')
            b++;
        if (b > e)
            return false;
        if (b == e)
            return isDigit(s.charAt(b));
        for (int i = b; i <= e; i++) {
            if (!isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public int getEIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E')
                return i;
        }
        return -1;
    }

}