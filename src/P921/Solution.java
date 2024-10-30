package P921;

class Solution {
    public int minAddToMakeValid(String s) {
        if (s.isEmpty())
            return 0;
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    result++;
                } else
                    count--;
            }
        }
        result += count;
        return result;
    }
}