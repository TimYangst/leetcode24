package P70ClimbingStairs;

public class Solution1 {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int a = 1;
        int b = 1;
        int i = 1;
        int newValue = 0;
        while (i < n) {
            newValue = a + b;
            a = b;
            b = newValue;
            i++;
        }
        return b;
    }

}
