package P41FirstMissingPositive;

class Solution1 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int k = nums.length - 1;
        int i = 0;
        while (i <= k) {
            if (nums[i] <= 0) {
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;
                k--;
            } else {
                i++;
            }
        }
        if (k < 0)
            return 1;
        int length = i;
        for (int j = length - 1; j >= 0; j--) {
            while (nums[j] <= length && nums[nums[j] - 1] != nums[j]) {
                int tmp = nums[nums[j] - 1];
                nums[nums[j] - 1] = nums[j];
                nums[j] = tmp;
            }
            for (int l = 0; l < nums.length; l++) {
                System.out.print(nums[l] + ", ");
            }
            System.out.println();
        }

        for (int j = 0; j < length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.firstMissingPositive(new int[] { 4, 1, 2, 3 });
    }
}