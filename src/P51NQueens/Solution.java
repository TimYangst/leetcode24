package P51NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    void search(int index, int[] pos, int[] check, int n, List<List<String>> result) {
        if (index == n) {
            record(pos, result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (place(index, i, pos, check, n)) {
                search(index + 1, pos, check, n, result);
                remove(index, i, pos, check, n);
            }
        }
    }

    void record(int[] pos, List<List<String>> result) {
        int n = pos.length;
        char[] arr = new char[pos.length];
        List<String> newItem = new ArrayList<>();
        Arrays.fill(arr, '.');
        for (int i = 0; i < n; i++) {
            arr[pos[i]] = 'Q';
            newItem.add(new String(arr));
            arr[pos[i]] = '.';
        }
        result.add(newItem);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 1) {
            result.add(List.of("Q"));
            return result;
        }
        ;
        if (n < 4)
            return result;
        int[] pos = new int[n];
        int[] check = new int[4];
        for (int i = 0; i < n; i++) {
            place(0, i, pos, check, n);
            search(1, pos, check, n, result);
            remove(0, i, pos, check, n);
        }
        return result;
    }

    boolean place(int x, int y, int[] pos, int[] check, int n) {
        if (((check[0] & (1 << x)) | (check[1] & (1 << y))
                | (check[2] & (1 << (x + y))) | (check[3] & (1 << (x - y + n - 1)))) != 0) {
            return false;
        }
        pos[x] = y;
        check[0] += (1 << x);
        check[1] += (1 << y);
        check[2] += (1 << (x + y));
        check[3] += (1 << (x - y + n - 1));
        return true;
    }

    void remove(int x, int y, int[] pos, int[] check, int n) {
        check[0] -= (1 << x);
        check[1] -= (1 << y);
        check[2] -= (1 << (x + y));
        check[3] -= (1 << (x - y + n - 1));
    }
}