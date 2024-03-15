package P66PlusOne;

class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        if (i < 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        digits[i]++;
        return digits;
    }
}