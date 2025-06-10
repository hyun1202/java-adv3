package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterExample {
    public static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> result = new ArrayList<>();

        for (Integer i : list) {
           if (predicate.test(i)) {
               result.add(i);
           }
        }
        return result;
    }
}
