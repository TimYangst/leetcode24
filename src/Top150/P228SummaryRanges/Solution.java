package Top150.P228SummaryRanges;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        int i = 0;
        int j = i;
        while (i < nums.length) {
            while (j < nums.length - 1 && nums[j + 1] == nums[j] + 1)
                j++;
            if (j == i) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(String.format("%s->%s", nums[i], nums[j]));
            }
            i = j + 1;
            j = i;
        }
        return result;
    }
}
