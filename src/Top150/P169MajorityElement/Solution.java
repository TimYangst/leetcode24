package Top150.P169MajorityElement;

class Solution {
    public int majorityElement(int[] nums) {
        int current = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current)
                count++;
            else {
                count--;
                if (count == 0) {
                    count = 1;
                    current = nums[i];
                }
            }
        }
        return current;
    }
}