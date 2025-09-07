package P2537;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int b = 0;
        int e = 0;
        int n = nums.length;
        int current = 0;
        long result = 0;
        count.put(nums[0], 1);
        int lastB = -1;
        int lastE = -1;
        while (e < nums.length - 1) {
            e++; 
            current += count.getOrDefault(nums[e], 0);
            System.out.println(current + " "+ b + " "+ e);
            count.compute(nums[e], (key, v) -> v==null? 1: v +1);
            if (current >= k) {
                while (b < e && current - (count.get(nums[b]) - 1) >= k){
                    current -= (count.get(nums[b]) - 1);
                    count.compute(nums[b], (key, v) -> v-1);
                    b++;
                } 
                if (lastB == -1) {
                    result += (b + 1) * (n-e);
                } else {
                    result += (b - lastB) * (n - e );
                }
                lastB = b;
                lastE = e; 
                current -= (count.get(nums[b]) - 1);
                count.compute(nums[b], (key, v) -> v - 1);
                b++;
            }
        }
        return result;
    }
}