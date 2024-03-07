package P14LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String common = strs[0];
        int result = strs[0].length();
        for (int index = 1; index < strs.length; index++) {
            result = Math.min(result, strs[index].length());
            if (result == 0)
                return "";
            for (int j = 0; j < result; j++) {
                if (strs[index].charAt(j) != common.charAt(j)) {
                    result = j;
                    break;
                }
            }
        }
        return common.substring(0, result);
    }
}