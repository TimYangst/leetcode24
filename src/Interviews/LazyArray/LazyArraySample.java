package Interviews.LazyArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LazyArraySample {

    private List<Integer> elements;
    private List<Function<List<Integer>, List<Integer>>> operations;

    public LazyArraySample(int[] array) {

        this.elements = new ArrayList<>(Arrays.stream(array).boxed().collect(Collectors.toList()));
        this.operations = new ArrayList<>();
    }

    public List<Integer> toList() {
        return evaluate();
    }

    public LazyArraySample map(Function<Integer, Integer> mapOp) {
        operations.add(list -> list.stream().map(mapOp).collect(Collectors.toList()));
        return this;
    }

    public LazyArraySample filter(Predicate<Integer> predOp) {
        operations.add(list -> list.stream().filter(predOp).collect(Collectors.toList()));
        return this;
    }

    public List<Integer> evaluate() {
        List<Integer> result = elements;
        for (Function<List<Integer>, List<Integer>> op : operations) {
            result = op.apply(result);
        }
        return result;
    }

    public int indexOf(Integer value) {
        List<Integer> evaluated = evaluate();
        return evaluated.indexOf(value);
    }

    public static void main(String[] args) {
        LazyArraySample array = new LazyArraySample(new int[] { 1, 2, 3 });
        System.out.println(array.map(a -> a * 3).indexOf(3));

        for (int i : array.toList()) {
            System.out.println(i);
        }
    }

}
