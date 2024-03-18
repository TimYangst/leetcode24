package Top150.P151ReverseWordsInAString;

class Solution {
    public String reverseWords(String s) {
        if (s.isEmpty())
            return s;
        int i = s.length() - 1;
        StringBuilder result = new StringBuilder();
        int currentEnd = 0;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            if (i < 0)
                break;
            currentEnd = i + 1;
            while (i > 0 && s.charAt(i - 1) != ' ')
                i--;
            if (result.length() != 0) {
                result.append(' ');
            }
            ;
            result.append(s.substring(i, currentEnd));
            i--;
        }
        return result.toString();
    }
}
