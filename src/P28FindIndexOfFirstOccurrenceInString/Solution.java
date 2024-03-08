package P28FindIndexOfFirstOccurrenceInString;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
    }
}