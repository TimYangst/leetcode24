package P68TextJustification;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if (words.length == 0)
            return result;
        int ci = 0;
        while (ci < words.length) {
            int i = ci;
            int cl = words[i].length();
            while (i + 1 < words.length && cl + words[i + 1].length() + 1 <= maxWidth) {
                i++;
                cl += (words[i].length() + 1);
            }
            StringBuilder current = new StringBuilder();
            if (i == words.length - 1 || i == ci) {
                for (int j = ci; j <= i; j++) {
                    current.append(words[j]);
                    if (j != i)
                        current.append(' ');
                }
                while (maxWidth - cl > 0) {
                    current.append(' ');
                    cl++;
                }
            } else {
                int remainsSpace = maxWidth - cl;
                int additional = remainsSpace / (i - ci);
                remainsSpace = remainsSpace % (i - ci);
                for (int j = ci; j <= i; j++) {
                    current.append(words[j]);
                    if (j != i) {
                        current.append(' ');
                        for (int k = 1; k <= additional; k++) {
                            current.append(' ');
                        }
                        if (remainsSpace > 0) {
                            current.append(' ');
                            remainsSpace--;
                        }
                    }
                }
            }
            result.add(current.toString());
            ci = i + 1;
        }
        return result;
    }
}