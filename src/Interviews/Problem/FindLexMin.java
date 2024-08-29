package Interviews.Problem;

import java.util.Arrays;

public class FindLexMin {

    String findLexMin(String s) {
        String ans = "";
        int r = 0;
        int l = -1;
        char[] ss = s.toCharArray();
        Arrays.sort(ss);

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < ss.length; j++) {
                if (s.charAt(j) == ss[i] && i == j) {
                    l = i;
                    break;
                } else if (s.charAt(j) == ss[i]) {
                    r = j;
                    break;
                }
            }
            if (r > 0)
                // to avoid unnecessary checking
                break;
        }

        // There is no group of sorted characters
        // in the beginning of the string S
        if (l == -1) {
            for (int i = r; i >= 0; i--)
                ans += s.charAt(i);
            for (int i = r + 1; i < s.length(); i++)
                ans += s.charAt(i);
        }
        // string S is already sorted or S = SS
        else if (l == s.length() - 1) {
            ans = s;
        }
        // Some part of string S in the beginning
        // is sorted
        else {
            for (int i = 0; i <= l; i++)
                ans += s.charAt(i);
            for (int i = r; i > l; i--)
                ans += s.charAt(i);
            for (int i = r + 1; i < s.length(); i++)
                ans += s.charAt(i);
        }
        // cout << "after " << i+1 << " operations
        // : " << ans << '\n'; use the above line of
        // code to see how S changes after every
        // operation

        return ans;
    }

    public static String findLexicographicallySmallestString(String S) {

        char[] ss = S.toCharArray();
        Arrays.sort(ss);
        int begin = 0;
        int n = S.length();
        while (begin < n && S.charAt(begin) == ss[begin])
            begin++;
        if (begin == n)
            return S;
        char minChar = S.charAt(begin);

        // Find the smallest character in the string
        for (int i = begin + 1; i < n; i++) {
            if (S.charAt(i) < minChar) {
                minChar = S.charAt(i);
            }
        }

        String smallest = S; // Initialize with the original string

        // Check all positions of the smallest character
        for (int i = begin; i < n; i++) {
            if (S.charAt(i) == minChar) {
                // Reverse the substring from the start to this position
                String offset = S.substring(0, begin);
                String reversedPart = new StringBuilder(S.substring(begin, i + 1)).reverse().toString();
                String candidate = offset + reversedPart + S.substring(i + 1);

                // Compare and update the smallest string if necessary
                if (candidate.compareTo(smallest) < 0) {
                    smallest = candidate;
                }
            }
        }

        return smallest;
    }

    // public static void main(String[] args) {
    // String S = "bccabac";
    // String smallestString = findLexicographicallySmallestString(S);
    // System.out.println("The lexicographically smallest string is: " +
    // smallestString);
    // }
    public static void main(String[] args) {
        System.out.println(findLexicographicallySmallestString("cabadabagf"));
        System.out.println(findLexicographicallySmallestString("aaadabacabagf"));
    }
}
