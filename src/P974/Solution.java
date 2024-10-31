package P974;

import java.util.HashMap;
import java.util.Map;

class Solution {

    int getPositiveMod(int n, int k) {
        int result = n % k;
        if (result < 0)
            return result + k;
        return result;
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            int m = getPositiveMod(nums[i], k);
            if (m == 0)
                result++;
            int index = getPositiveMod(k - m - offset, k);
            result += count.getOrDefault(index, 0);
            System.out.println(index + " : " + result);
            offset += m;
            count.compute(getPositiveMod(m - offset, k), (key, value) -> (value == null ? 1 : value + 1));
        }
        return result;
    }
}