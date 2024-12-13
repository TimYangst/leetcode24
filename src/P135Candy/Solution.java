package P135Candy;

class Solution {
    public int candy(int[] ratings) {
        int l = ratings.length;
        if (ratings.length == 1)
            return 1;
        int left[] = new int[l];
        int right[] = new int[l];
        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            if (ratings[l - i - 1] > ratings[l - i])
                right[l - i - 1] = right[l - i] + 1;
        }
        int result = 0;
        for (int i = 0; i < l; i++) {
            result += Math.max(left[i], right[i]) + 1;
        }
        return result;
    }
}
