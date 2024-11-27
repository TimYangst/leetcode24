package P443;

class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int result = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }
            chars[result] = current;
            result++;
            if (count != 1) {
                String ct = String.valueOf(count);
                for (int j = 0; j < ct.length(); j++) {
                    chars[result] = ct.charAt(j);
                    result++;
                }
            }
        }
        return result;
    }
}
