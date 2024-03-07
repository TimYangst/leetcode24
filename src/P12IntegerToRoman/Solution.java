package P12IntegerToRoman;

class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            num -= 1000;
            sb.append("M");
        }
        num = handle(100, "C", "D", "M", sb, num);
        num = handle(10, "X", "L", "C", sb, num);
        num = handle(1, "I", "V", "X", sb, num);
        return sb.toString();
    }

    int handle(int unit, String oneSymble, String fiveSymble, String upperOneSymble, StringBuilder sb, int num) {
        if (num / unit == 9) {
            sb.append(oneSymble).append(upperOneSymble);
            num -= 9 * unit;
        }
        if (num / unit >= 5) {
            sb.append(fiveSymble);
            num -= 5 * unit;
        }
        if (num / unit == 4) {
            sb.append(oneSymble).append(fiveSymble);
            num -= 4 * unit;
        }
        while (num >= unit) {
            sb.append(oneSymble);
            num -= unit;
        }
        return num;
    }
}