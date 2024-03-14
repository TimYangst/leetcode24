package P60PermutationSequence;

class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0)
            return "";
        if (n == 1)
            return "1";

        int[] count = new int[n + 1];
        count[0] = 1;
        List<Integer> remains = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            count[i] = count[i - 1] * i;
            remains.add(i);
        }
        StringBuilder result = new StringBuilder();
        fill(result, n, k, remains, count);
        return result.toString();
    }

    void fill(StringBuilder result, int n, int k, List<Integer> remains, int[] count) {
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                result.append(remains.get(i - 1));
            }
            return;
        } else if (k == count[n]) {
            for (int i = n - 1; i >= 0; i--) {
                result.append(remains.get(i));
            }
            return;
        }

        int value = count[n - 1];
        int index = (k - 1) / value;
        result.append(pick(remains, index));
        fill(result, n - 1, (k - 1) % value + 1, remains, count);
    }

    int pick(List<Integer> remains, int index) {
        int result = remains.get(index);
        remains.remove(index);
        return result;
    }
}