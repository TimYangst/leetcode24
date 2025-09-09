package P1248;

class Solution1 {

    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int current = 0;
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    current++;
                    result += current;
                } else
                    current = 0;
            }
            return result;
        }
        int last = -1;
        int b = 0;
        while (b < nums.length && nums[b] % 2 == 0)
            b++;
        if (b == nums.length)
            return 0;
        int e = b;
        while (e < nums.length) {
            if (nums[e] % 2 == 1) {
                current++;
            }

            if (current == k) {
                result += b - last;
            } else if (current > k) {
                last = b;
                b++;
                current--;
                while (b < nums.length && nums[b] % 2 == 0)
                    b++;
                result += b - last;
            }
            if (b > e)
                e = b;
            else
                e++;
        }
        return result;
    }
}