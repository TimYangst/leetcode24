package P89GrayCode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0)
            return new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        last.add(0);
        last.add(1);
        int i = 1;
        int total = 2;
        while (i < n) {
            for (int j = total - 1; j >= 0; j--) {
                last.add(last.get(j) + total);
            }
            total = total << 1;
            i++;
        }
        return last;
    }
}