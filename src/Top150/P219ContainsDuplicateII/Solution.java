package Top150.P219ContainsDuplicateII;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1)
            return false;
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!lastIndex.containsKey(nums[i])) {
                lastIndex.put(nums[i], i);
            } else {
                int last = lastIndex.get(nums[i]);
                if (i - last <= k)
                    return true;
                lastIndex.put(nums[i], i);
            }
        }
        return false;
    }
}
