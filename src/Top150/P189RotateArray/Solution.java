package Top150.P189RotateArray;

class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0)
            return;
        int remains = length;
        boolean[] moved = new boolean[length];
        int i = 0;
        while (remains > 0) {
            while (moved[i])
                i++;
            int tmp = nums[i];
            int j = i;
            int next = (j + (length - k)) % length;
            while (next != i) {
                nums[j] = nums[next];
                moved[j] = true;
                remains--;
                j = next;
                next = (j + (length - k)) % length;
            }
            nums[j] = tmp;
            moved[j] = true;
            remains--;
        }
    }
}