package P67AddBinary;

class Solution {
    public String addBinary(String a, String b) {
        if (a.isEmpty() || a.equals("0"))
            return b;
        if (b.isEmpty() || b.equals("0"))
            return a;
        StringBuilder result = new StringBuilder();
        int pop = 0;
        int current = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            current = a.charAt(i) - '0' + b.charAt(j) - '0' + pop;
            pop = current / 2;
            current = current % 2;
            result.append((char) ('0' + current));
            i--;
            j--;
        }
        while (i >= 0) {
            current = a.charAt(i) - '0' + pop;
            pop = current / 2;
            current = current % 2;
            result.append((char) ('0' + current));
            i--;
        }
        while (j >= 0) {
            current = b.charAt(j) - '0' + pop;
            pop = current / 2;
            current = current % 2;
            result.append((char) ('0' + current));
            j--;
        }
        if (pop == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }
}