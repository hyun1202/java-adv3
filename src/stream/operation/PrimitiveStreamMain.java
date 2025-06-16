package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {
    public static void main(String[] args) {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);

        // 범위 생성
        IntStream range1 = IntStream.range(1, 6);  // 1~5
        IntStream range2 = IntStream.rangeClosed(1, 5); // 1~5

        // 모든 통계 정보
        IntSummaryStatistics stats = IntStream.range(1, 6)
                .summaryStatistics();

        System.out.println("합계: " + stats.getSum());
        System.out.println("평균: " + stats.getAverage());
        System.out.println("최대값: " + stats.getMax());
        System.out.println("최소값: " + stats.getMin());
        System.out.println("개수: " + stats.getCount());

        // intStream -> longStream
        LongStream longStream = IntStream.range(1, 5).asLongStream();

        // intStream -> doubleStream
        DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();

        // intStream -> Stream<Integer>
        Stream<Integer> boxedStream = IntStream.range(1, 5).boxed();

        // int -> long 변환
        LongStream mappedLong = IntStream.range(1, 5)
                .mapToLong(i -> i * 10L);

        // int -> 객체 변환 매핑
        Stream<String> mappedObj = IntStream.range(1, 5)
                .mapToObj(i -> "Number: " + i);

        // 객체 스트림 -> 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream = integerStream.mapToInt(i -> i * 10);

        // 객체 스트림 -> 기본형 특화 스트림으로 매핑 활용
        int result = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(i -> i)
                .sum();
        System.out.println("result = " + result);
    }
}
