package P974;

class Solution {

    int getPositiveMod(int n, int k) {
        int result = n % k;
        if (result < 0)
            return result + k;
        return result;
    }

    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int result = 0;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int index = getPositiveMod(prefix, k);
            result += count[index];
            count[index]++;
        }
        return result;
    }
}