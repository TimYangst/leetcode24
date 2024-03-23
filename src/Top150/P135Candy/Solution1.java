package Top150.P135Candy;

class Solution1 {
    public int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;
        int[] result = new int[ratings.length];
        int[] index = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            index[i] = i;
        }
        sortByIndex(index, ratings, 0, ratings.length - 1);
        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            fill(index[i], result, ratings);
            total += result[index[i]];
        }
        return total;
    }

    void sortByIndex(int[] index, int[] ratings, int b, int e) {
        if (b >= e)
            return;
        int m = (b + e) / 2;
        int tmp = index[m];
        index[m] = index[e];
        int i = b;
        int j = e;
        while (i < j) {
            while (i < j && ratings[index[i]] <= ratings[tmp])
                i++;
            if (i < j) {
                index[j] = index[i];
                j--;
            }
            while (i < j && ratings[tmp] <= ratings[index[j]])
                j--;
            if (i < j) {
                index[i] = index[j];
                i++;
            }
        }
        index[i] = tmp;
        if (b < i - 1)
            sortByIndex(index, ratings, b, i - 1);
        if (i + 1 < e)
            sortByIndex(index, ratings, i + 1, e);
    }

    void fill(int i, int[] result, int[] ratings) {
        int minFill = 1;
        if (i > 0) {
            if (result[i - 1] > 0 && ratings[i] > ratings[i - 1])
                minFill = result[i - 1] + 1;
        }
        if (i < ratings.length - 1) {
            if (result[i + 1] > 0 && ratings[i] > ratings[i + 1])
                minFill = Math.max(minFill, result[i + 1] + 1);
        }
        result[i] = minFill;
    }
}