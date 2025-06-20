package functional;

import java.util.function.Function;

public class CompositionMain1 {

    public static void main(String[] args) {
        // 1. x를 입력받아 x*x
        Function<Integer, Integer> square = x -> x * x;

        // 2. x를 입력받아 x+1하는 함수
        Function<Integer, Integer> add = x -> x + 1;

        // 함수 합성
        // compose: add먼저 적용 (뒤)
        // square(add(2)) -> square(3) -> 9
        Function<Integer, Integer> newFunc1 = square.compose(add);
        System.out.println("newFunc1.apply(2) = " + newFunc1.apply(2));

        // 2. andThen()을 이용한 새로운 함수 생성
        // andThen: square 먼저 적용 (앞)
        // add(square(2)) -> -> add(4) -> 5
        Function<Integer, Integer> newFunc2 = square.andThen(add);
        System.out.println("newFunc2.apply(2) = " + newFunc2.apply(2));
    }
}
