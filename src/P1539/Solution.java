package P1539;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr.length == 0)
            return k;
        if (arr[arr.length - 1] == arr.length)
            return k + arr.length;
        int b = 0;
        int e = arr.length - 1;
        while (b < e) {
            int mid = (b + e) / 2;
            if (arr[mid] - (mid + 1) >= k)
                e = mid;
            else
                b = mid + 1;
        }
        if (arr[b] - (b + 1) == k) {
            return arr[b] - 1;
        } else if (arr[b] - (b + 1) > k) {
            if (b == 0)
                return k;
            return arr[b] - (arr[b] - (b + 1) - k) - 1;
        } else {
            return arr[b] + (k - (arr[b] - (b + 1)));
        }
    }
}