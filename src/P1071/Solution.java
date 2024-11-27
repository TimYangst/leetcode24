package P1071;

class Solution {

    int gcd(int l1, int l2) {
        if (l1 < l2)
            return gcd(l2, l1);
        if (l1 % l2 == 0)
            return l2;
        return gcd(l2, l1 % l2);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return "";
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int length = gcd(str1.length(), str2.length());
        return str1.substring(0, length);
    }
}
