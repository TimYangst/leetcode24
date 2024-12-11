package P658;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        if (k == 0)
            return result;
        int b = 0;
        int e = arr.length - 1;
        int loc = 0;
        while (b <= e) {
            int mid = b + (e - b) / 2;
            if (arr[mid] <= x) {
                loc = mid;
                b = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        if (loc < arr.length - 1 && Math.abs(arr[loc] - x) > Math.abs(arr[loc + 1] - x))
            loc++;
        result.add(arr[loc]);
        int i = loc - 1;
        int j = loc + 1;
        while (result.size() < k) {
            if (i < 0)
                result.add(arr[j++]);
            else if (j >= arr.length)
                result.addFirst(arr[i--]);
            else {
                if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x))
                    result.addFirst(arr[i--]);
                else
                    result.add(arr[j++]);
            }
        }
        return result;
    }
}
