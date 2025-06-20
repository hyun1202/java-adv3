package functional;

import java.util.function.Function;

public class CompositionMain2 {

    public static void main(String[] args) {
        // 1. String -> Integer
        Function<String, Integer> parseInt = Integer::parseInt;

        // 2. Integer -> Integer (제곱)
        Function<Integer, Integer> square = x -> x * x;

        // 3. Integer -> String
        Function<Integer, String> toString = x -> "결과: " + x;

        // parseInt -> square -> toString 순서로 합성됨
        Function<String, String> finalFunc = parseInt
                .andThen(square)
                .andThen(toString);

        String result1 = finalFunc.apply("5");
        System.out.println("result1 = " + result1);

        String result2 = finalFunc.apply("10");
        System.out.println("result2 = " + result2);

        // 또 다른 조합
        // parseInt -> square
        Function<String, Integer> stringToSquareFunc = parseInt.andThen(square);
        Integer result3 = stringToSquareFunc.apply("5");
        System.out.println("result3 = " + result3);
    }
}
