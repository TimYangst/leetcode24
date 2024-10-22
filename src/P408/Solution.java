package P408;

class Solution {
    boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.equals(""))
            return abbr.equals("");

        int i = 0;
        int j = 0;
        while (j < abbr.length() && i < word.length()) {
            if (isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0')
                    return false;
                int k = j;
                while (k < abbr.length() && isDigit(abbr.charAt(k)))
                    k++;
                try {
                    int l = Integer.parseInt(abbr.substring(j, k));
                    if (l > word.length() || (i + l) > word.length())
                        return false;
                    j = k;
                    i = i + l;
                } catch (Exception e) {
                    return false;
                }
            } else {
                if (abbr.charAt(j) != word.charAt(i))
                    return false;
                i++;
                j++;
            }
        }
        return j == abbr.length() && i == word.length();
    }
}