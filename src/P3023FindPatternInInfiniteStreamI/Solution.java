package P3023FindPatternInInfiniteStreamI;

/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 * public InfiniteStream(int[] bits);
 * public int next();
 * }
 */
class InfiniteStream {
    public InfiniteStream(int[] bits) {
    };

    public int next() {
        return 0;
    };
}

class Solution {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        int next[] = new int[pattern.length];
        next[0] = -1;
        int j = -1;
        int i = 0;
        while (i < pattern.length - 1) {
            if (j == -1 || pattern[i] == pattern[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        j = 0;
        i = -1;
        int current = infiniteStream.next();
        while (true) {
            if (j == -1 || current == pattern[j]) {
                j++;
                i++;
                if (j == pattern.length)
                    break;
                current = infiniteStream.next();
            } else
                j = next[j];
        }
        return i - j + 1;
    }
}