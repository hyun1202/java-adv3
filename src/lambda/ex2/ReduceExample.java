package lambda.ex2;

import java.util.List;

public class ReduceExample {
    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;

        for (Integer i : list) {
            result = reducer.reduce(result, i);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        int add = reduce(list, 0, (acc, i) -> acc + i);
        int product = reduce(list, 1, (acc, i) -> acc * i);
        System.out.println("add = " + add);
        System.out.println("m = " + product);
    }
}
