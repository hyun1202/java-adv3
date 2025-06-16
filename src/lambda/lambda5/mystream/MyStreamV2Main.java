package lambda.lambda5.mystream;

import lambda.lambda5.GenericFilter;
import lambda.lambda5.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class MyStreamV2Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> returnValueResult = returnValue(numbers);
        System.out.println("returnValueResult = " + returnValueResult);

        List<Integer> methodChainResult = methodChain(numbers);
        System.out.println("methodChainResult = " + methodChainResult);
    }

    private static List<Integer> returnValue(List<Integer> numbers) {
        MyStreamV2 stream = MyStreamV2.of(numbers);
        MyStreamV2 filteredStream = stream.filter(n -> n % 2 == 0);
        MyStreamV2 mappedStream = filteredStream.map(n -> n * 2);
        return mappedStream.toList();
    }

    private static List<Integer> methodChain(List<Integer> numbers) {
        return MyStreamV2.of(numbers)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .toList();
    }
}
