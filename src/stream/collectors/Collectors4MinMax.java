package stream.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {
    public static void main(String[] args) {
        // 다운스트림 컬렉터에서 사용
        Integer max1 = Stream.of(1, 2, 3)
                .collect(Collectors.maxBy(
                        (i1, i2) -> i1.compareTo(i2)
                )).get();
        System.out.println("max1 = " + max1);

        Integer max2 = Stream.of(1, 2, 3)
                .max((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("max2 = " + max2);

        // 기본형 특화 스트림 사용
        int max3 = IntStream.of(1, 2, 3)
                .max().getAsInt();
        System.out.println("max3 = " + max3);
    }
}
