package Interviews.LampsIlluminationOnANumberLine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static int[] numbersOfLamps(int[][] segments, int[] points) {
        Set<Integer> coordinates = new TreeSet<>();
        Map<Integer, Integer> adding = new HashMap<>();
        Map<Integer, Integer> deleting = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int[] segment : segments) {
            adding.compute(segment[0], (key, value) -> (value == null ? 1 : value + 1));
            deleting.compute(segment[1], (key, value) -> (value == null ? 1 : value + 1));
            coordinates.add(segment[0]);
            coordinates.add(segment[1]);
        }
        for (int point : points) {
            coordinates.add(point);
            resultMap.put(point, 0);
        }

        AtomicInteger current = new AtomicInteger(0);
        for (int coordinate : coordinates) {
            current.addAndGet(adding.getOrDefault(coordinate, 0));
            resultMap.computeIfPresent(coordinate, (key, value) -> current.get());
            current.addAndGet(-deleting.getOrDefault(coordinate, 0));
        }
        int[] result = new int[points.length];

        for (int index = 0; index < points.length; index++) {
            result[index] = resultMap.get(points[index]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] lamps = { { 1, 4 }, { 2, 5 }, { 7, 8 } };
        int[] points = { 3, 5, 8 };
        int[] result = numbersOfLamps(lamps, points);
        System.out.println(Arrays.toString(result));
    }

}
