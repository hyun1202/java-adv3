package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperationMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("collect -List 수집");
        List<Integer> evenNumbers1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("evenNumbers1 = " + evenNumbers1);
        System.out.println();

        System.out.println("toArray - 배열로 변환");
        Integer[] arr = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]::new);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println();

        System.out.println("findAny - 아무 요소 하나 찾기");
        Integer any = numbers.stream()
                .filter(n -> n > 5)
                .findAny().get();
        System.out.println("any = " + any);
        System.out.println();

        System.out.println("anyMatch - 조건을 만족하는 요소 존재 여부");
        boolean hasEven = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println("hasEven = " + hasEven);
        System.out.println();

        System.out.println("allMatch - 모든 요소가 조건을 만족하는지");
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("allPositive = " + allPositive);
        System.out.println();

        System.out.println("noneMatch - 조건을 만족하는 요소가 없는지");
        boolean noNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("noNegative = " + noNegative);
        System.out.println();
    }
}
