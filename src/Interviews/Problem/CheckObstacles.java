package Interviews.Problem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CheckObstacles {

    private Map<Integer, Integer> buildCoordinatesMapping(int[][] ops) {
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] == 2) {
                sortedSet.add(ops[i][1]);
                sortedSet.add(ops[i][2]);
            } else {
                sortedSet.add(ops[i][1]);
            }
        }
        Map<Integer, Integer> result = new HashMap<>();
        int index = 0;
        for (Integer originalCoordinate : sortedSet) {
            result.put(originalCoordinate, index);
            index++;
        }
        return result;
    }

    void insert(boolean[] segmentTree, int current, int left, int right, int target) {
        if (target < left || target > right)
            return;
        if (left == right) {
            segmentTree[current] = true;
            return;
        }
        int leftChild = current << 1;
        int rightChild = leftChild + 1;
        int mid = (left + right) >> 1;
        insert(segmentTree, leftChild, left, mid, target);
        insert(segmentTree, rightChild, mid + 1, right, target);
        segmentTree[current] = segmentTree[leftChild] || segmentTree[rightChild];
    }

    boolean query(boolean[] segmentTree, int current, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft <= left && queryRight >= right) {
            return segmentTree[current];
        }
        if (queryLeft > right || queryRight < left)
            return false;
        if (left == right)
            return segmentTree[current];
        int mid = (left + right) >> 1;
        int leftChild = current << 1;
        int rightChild = leftChild + 1;
        return query(segmentTree, leftChild, left, mid, queryLeft, queryRight)
                || query(segmentTree, rightChild, mid + 1, right, queryLeft, queryRight);
    }

    String checkObstacles(int[][] ops) {
        Map<Integer, Integer> axisMapping = buildCoordinatesMapping(ops);
        int elements = axisMapping.size();
        boolean[] segmentTree = new boolean[elements * 4];

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] == 2) {
                if (query(segmentTree, 0, 0, elements - 1, axisMapping.get(ops[i][1]), axisMapping.get(ops[i][2]))) {
                    result.append('1');
                } else {
                    result.append('0');
                }
            } else {
                insert(segmentTree, 0, 0, elements - 1, axisMapping.get(ops[i][1]));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CheckObstacles checkObstacles = new CheckObstacles();
        System.out.println(checkObstacles.checkObstacles(new int[][] { { 1, 2 }, { 2, 1, 3 }, { 1, 5 }, { 2, 7, 8 } }));
    }

}
