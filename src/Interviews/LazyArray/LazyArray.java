package Interviews.LazyArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LazyArray {
    private List<Integer> elements;

    private List<Function<Integer, Integer>> ops;

    public LazyArray(int[] numbers) {
        this.elements = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        this.ops = new ArrayList<>();
    }

    public LazyArray map(Function<Integer, Integer> op) {
        ops.add(op);
        return this;
    }

    public List<Integer> evaluate() {
        return this.elements.stream().map(element -> {
            int result = element;
            for (Function<Integer, Integer> op : ops) {
                result = op.apply(result);
            }
            return result;
        }).collect(Collectors.toList());
    }

    public int indexOf(int value) {
        return this.evaluate().indexOf(value);
    }

    public static void main(String[] args) {
        LazyArray array = new LazyArray(new int[] { 10, 20, 30, 40, 50 });
        System.out.println("array.map(x -> x*2).indexOf(40) == " + array.map(x -> x * 2).indexOf(40));

    }

}
