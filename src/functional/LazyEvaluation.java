package functional;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluation {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream()
                .filter(n -> {
                    System.out.println("filter: " + n);
                    return n % 2 == 0;
                });

        System.out.println("중간 연산은 최종연산이 호출되기 전까진 실행되지 않는다.");

        System.out.println("최종 연산 시작");
        // 최종 연산 시작
        stream.toList();
    }
}
