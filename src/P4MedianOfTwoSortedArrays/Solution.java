package P4MedianOfTwoSortedArrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total == 0)
            return 0;
        boolean isAvg = (total % 2 == 0);
        int[] tmp;
        if (nums1.length > nums2.length) {
            tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0) {
            return calcValue(nums2, (l2 + 1) / 2 - 1, isAvg);
        }
        if (total == 2) {
            return avg(nums1[0], nums2[0]);
        }
        if (nums1[l1 - 1] <= nums2[0]) {
            if (l1 == l2)
                return avg(nums1[l1 - 1], nums2[0]);
            return calcValue(nums2, (total + 1) / 2 - l1 - 1, isAvg);
        }
        if (nums1[0] >= nums2[l2 - 1]) {
            if (l1 == l2)
                return avg(nums1[0], nums2[l2 - 1]);
            return calcValue(nums2, (total + 1) / 2 - 1, isAvg);
        }
        // Binary search deviding point.
        int left = 0;
        int right = l1;
        while (left < right) {
            int m1 = (left + right) / 2;
            int m2 = getOtherCut(nums1, nums2, m1);
            if (m1 == 0) {
                if (nums2[m2 - 1] > nums1[m1]) {
                    left = m1 + 1;
                } else
                    break;
            } else if (m1 == l1) {
                if (nums1[m1 - 1] > nums2[m2]) {
                    right = m1 - 1;
                } else
                    break;
            } else {
                if (nums1[m1 - 1] > nums2[m2]) {
                    right = m1 - 1;
                } else if (nums2[m2 - 1] > nums1[m1]) {
                    left = m1 + 1;
                } else {
                    left = m1;
                    break;
                }
            }
        }
        int maxLeft = getMaxLeft(nums1, nums2, left);
        int minRight = getMinRight(nums1, nums2, left);
        if (isAvg) {
            return avg(maxLeft, minRight);
        }
        return maxLeft;
    }

    int getMaxLeft(int[] nums1, int[] nums2, int c1) {
        int c2 = getOtherCut(nums1, nums2, c1);
        int maxLeft = Integer.MIN_VALUE;
        if (c1 > 0) {
            maxLeft = Math.max(maxLeft, nums1[c1 - 1]);
        }
        if (c2 > 0) {
            maxLeft = Math.max(maxLeft, nums2[c2 - 1]);
        }
        return maxLeft;
    }

    public int getMinRight(int[] nums1, int[] nums2, int c1) {
        int c2 = getOtherCut(nums1, nums2, c1);
        int minRight = Integer.MAX_VALUE;
        if (c1 < nums1.length) {
            minRight = Math.min(minRight, nums1[c1]);
        }
        if (c2 < nums2.length) {
            minRight = Math.min(minRight, nums2[c2]);
        }
        return minRight;
    }

    int getOtherCut(int[] nums1, int[] nums2, int c) {
        return (nums1.length + nums2.length + 1) / 2 - c;
    }

    public double avg(int num1, int num2) {
        return (num1 + num2) / 2.0;
    }

    public double calcValue(int[] nums, int index, boolean isAvg) {
        if (isAvg) {
            return avg(nums[index], nums[index + 1]);
        }
        return nums[index];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
        System.out.println(solution.findMedianSortedArrays(new int[] { 4, 6 }, new int[] { 1, 2, 3, 5 }));
    }
}
