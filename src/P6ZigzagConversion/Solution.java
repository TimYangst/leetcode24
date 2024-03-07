package P6ZigzagConversion;

public class Solution {

    public String convert(String s, int numRows) {
        if (s.isEmpty() || s.length() == 1 || numRows == 1 || numRows >= s.length())
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int delta;
            delta = 2 * (numRows - 1);
            int b = i;
            while (b < s.length()) {
                sb.append(s.charAt(b));
                if (i != 0 && i != numRows - 1) {
                    int next = b + (numRows - 1 - i) * 2;
                    if (next < s.length()) {
                        sb.append(s.charAt(next));
                    }
                }
                b += delta;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}
