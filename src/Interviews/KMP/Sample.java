package Interviews.KMP;

public class Sample {

    static int[] getNext(String pattern) {
        int[] next = new int[pattern.length() + 1];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    static int match(String s, String pattern, int[] next) {
        int i = -1;
        int j = -1;
        while (i < s.length() && j < pattern.length()) {
            if (j == -1 || s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length())
            return i - j;
        return -1;
    }

    public static void main(String[] args) {
        String pattern = "abababcabab";
        int[] next = getNext(pattern);

        for (int i = 0; i < pattern.length(); i++) {
            System.out.print(pattern.charAt(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
        System.out.println();

        System.out.println(match("abababababababcababcabababcababab", pattern, next));
    }
}
