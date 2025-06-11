package lambda.ex3;

import lambda.ex2.MyPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class FilterExample {
    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();

        for (Integer i : list) {
           if (predicate.test(i)) {
               result.add(i);
           }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> data = List.of(-3, -2, -1, 1, 2, 3, 5);

        List<Integer> negative = filter(data, n -> n < 0);
        List<Integer> even = filter(data, n -> n % 2 == 0);

        System.out.println("negative = " + negative);
        System.out.println("even = " + even);
    }
}
