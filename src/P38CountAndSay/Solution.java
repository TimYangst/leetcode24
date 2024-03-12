package P38CountAndSay;

class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String current = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < current.length()) {
                int count = 1;
                while (j + 1 < current.length() && current.charAt(j + 1) == current.charAt(j)) {
                    j++;
                    count++;
                }
                sb.append(count).append(current.charAt(j));
                j++;
            }
            current = sb.toString();
        }
        return current;
    }
}
