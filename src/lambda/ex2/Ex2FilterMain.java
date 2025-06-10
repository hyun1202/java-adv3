package lambda.ex2;

import java.util.List;

public class Ex2FilterMain {
    public static void main(String[] args) {
        List<Integer> data = List.of(-3, -2, -1, 1, 2, 3, 5);

        List<Integer> negative = FilterExample.filter(data, n -> n < 0);
        List<Integer> even = FilterExample.filter(data, n -> n % 2 == 0);

        System.out.println("negative = " + negative);
        System.out.println("even = " + even);
    }
}
