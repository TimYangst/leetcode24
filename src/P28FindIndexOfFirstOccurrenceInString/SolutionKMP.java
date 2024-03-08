package P28FindIndexOfFirstOccurrenceInString;

public class SolutionKMP {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        int[] next = new int[needle.length() + 1];
        calcNext(next, needle);
        int j = 0;
        for (int i = 1; i <= haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i - 1) != needle.charAt(j))
                j = next[j];
            if (haystack.charAt(i - 1) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length())
                return i - j;
        }
        return -1;
    }

    void calcNext(int[] next, String needle) {
        next[1] = 0;
        int k = 0;
        for (int i = 2; i <= needle.length(); i++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(i - 1)) {
                k = next[k];
            }
            if (needle.charAt(k) == needle.charAt(i - 1))
                k++;
            next[i] = k;
        }
    }

    public static void main(String[] args) {
        SolutionKMP solution = new SolutionKMP();
        System.out.println(solution.strStr("mississippi", "issip"));
        System.out.println(solution.strStr("babba", "bbb"));
    }
}
