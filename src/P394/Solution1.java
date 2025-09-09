package P394;

class SectionResult {
    String result;
    int nextIndex;

    SectionResult(String result, int nextIndex) {
        this.result = result;
        this.nextIndex = nextIndex;
    }
}

class Solution1 {

    private SectionResult decodeSection(String s, int b) {
        int i = b;
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && s.charAt(i) != ']') {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
                i++;
            } else {
                int count = 0;
                while ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // s[i] = '['
                SectionResult next = decodeSection(s, i + 1);
                for (int j = 0; j < count; j++) {
                    sb.append(next.result);
                }
                i = next.nextIndex + 1;
            }
        }
        return new SectionResult(sb.toString(), i);
    }

    public String decodeString(String s) {
        if (s.length() <= 3)
            return s;
        return decodeSection(s, 0).result;
    }
}