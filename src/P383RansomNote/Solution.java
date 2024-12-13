package P383RansomNote;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] index = new int[255];
        for (int i = 0; i < magazine.length(); i++) {
            index[magazine.charAt(i)]++;
        }
        int remains;
        for (int i = 0; i < ransomNote.length(); i++) {
            remains = --index[ransomNote.charAt(i)];
            if (remains < 0)
                return false;
        }
        return true;
    }
}