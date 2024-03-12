package P43MultiplyStrings;

import java.util.Arrays;

class Solution {
    public String multiply(String num1, String num2) {
        char[] result = new char[num1.length() + num2.length()];
        Arrays.fill(result, (char) 0);

        int l1 = num1.length(), l2 = num2.length();

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                result[i + j] += (num1.charAt(l1 - i - 1) - '0') * (num2.charAt(l2 - j - 1) - '0');
                if (result[i + j] >= 10) {
                    result[i + j + 1] += (char) (result[i + j] / 10);
                    result[i + j] = (char) (result[i + j] % 10);
                }
            }
        }
        int length = l1 + l2;
        while (result[length - 1] == 0 && length > 1) {
            length--;
        }
        StringBuilder sb = new StringBuilder();
        while (length > 0) {
            sb.append((char) (result[length - 1] + '0'));
            length--;
        }
        return sb.toString();
    }
}