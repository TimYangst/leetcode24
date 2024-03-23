package Top150.P274HIndex;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        if (citations.length == 1) {
            if (citations[0] == 0)
                return 0;
            return 1;
        }
        Arrays.sort(citations);
        if (citations[0] >= citations.length)
            return citations.length;
        if (citations[citations.length - 1] == 0)
            return 0;
        return bs(citations, 1, citations.length - 1);
    }

    int bs(int[] citations, int b, int e) {
        if (b == e)
            return b;
        int m = (b + e) / 2;
        int l = citations.length;
        if (citations[l - m - 1] < m + 1 && citations[l - m] >= m)
            return m;
        if (citations[l - m - 1] >= m + 1)
            return bs(citations, m + 1, e);
        return bs(citations, b, m);
    }
}