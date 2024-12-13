package P76MinimumWindowSubstring;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0)
            return "";

        int remains = 0;
        int[] index = new int[256];
        int[] current = new int[256];

        for (int i = 0; i < t.length(); i++) {
            index[t.charAt(i)]++;
            remains++;
        }

        int i = 0;
        while (i < s.length() && index[s.charAt(i)] == 0)
            i++;
        if (i == s.length())
            return "";

        int j = i;
        char b, e;
        while (remains > 0 && j < s.length()) {
            e = s.charAt(j);
            j++;
            if (index[e] > 0) {
                if (current[e] < index[e])
                    remains--;
                current[e]++;
            }
        }
        if (remains > 0)
            return "";

        b = s.charAt(i);
        while (i < j && (index[b] == 0 || current[b] > index[b])) {
            if (current[b] > index[b])
                current[b]--;
            i++;
            b = s.charAt(i);
        }

        String result = s.substring(i, j);
        if (j - i == t.length())
            return result;

        while (j < s.length()) {
            current[b]--;
            remains++;
            i++;
            b = s.charAt(i);

            while (j < s.length() && remains > 0) {
                e = s.charAt(j);
                if (index[e] > 0) {
                    if (current[e] < index[e]) {
                        remains--;
                    }
                    current[e]++;
                }
                j++;
            }

            while (i < j && (index[b] == 0 || current[b] > index[b])) {
                if (current[b] > index[b])
                    current[b]--;
                i++;
                b = s.charAt(i);
            }
            if (remains == 0 && j - i < result.length()) {
                result = s.substring(i, j);
            }
        }
        return result;
    }
}