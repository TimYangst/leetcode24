package Top150.P242ValidAnagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int remains;
        for (int i = 0; i < t.length(); i++) {
            remains = --count[t.charAt(i)];
            if (remains < 0)
                return false;
        }
        return true;
    }
}
