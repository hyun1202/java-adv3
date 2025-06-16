package stream.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("sorted 기본 정렬");
        Stream.of(3,1,5,4,9,2)
                .sorted()
                .forEach(System.out::print);
        System.out.println();

        System.out.println("sorted 내림차순 정렬");
        Stream.of(3,1,5,4,9,2)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
        System.out.println();

        System.out.println("peek 동작 확인용");
        numbers.stream()
                .peek(n -> System.out.print("before : " + n))
                .map(n -> n * n)
                .peek(n -> System.out.print(" after : " + n + " result: "))
                .limit(5)
                .forEach(System.out::print);
        System.out.println();

        System.out.println("skip - 처음 요소를 건너 뛰기");
        numbers.stream()
                .skip(3)
                .forEach(System.out::print);
        System.out.println();

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println("takeWhile - 5보다 작은 동안만 선택");
        numbers2.stream()
                .takeWhile(n -> n < 5)
                .forEach(System.out::print);
        System.out.println();

        System.out.println("dropWhile - 5보다 작은 동안 건너 뛰기");
        numbers2.stream()
                .dropWhile(n -> n < 5)
                .forEach(System.out::print);
    }
}
