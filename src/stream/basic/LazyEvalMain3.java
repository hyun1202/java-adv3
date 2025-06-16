package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain3 {
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    // 일괄 처리 -> 공정을 단계별로 쪼개서 데이터 전체를 한번에 처리함
    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 ==");
        Integer result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter(): " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map(): " + i + " -> " + mapped);
                    return mapped;
                })
                .getFirst();

        System.out.println("result = " + result);
        System.out.println("==MyStreamV3 end ==");
    }

    // 파이프라인 처리 -> 각 공정이 끝난 제품을 즉시 다음 단계로 넘긴다. (체이닝)
    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작");
        Integer result = data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter(): " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map(): " + i + " -> " + mapped);
                    return mapped;
                })
                .findFirst().get();

        System.out.println("result = " + result);
        System.out.println("==Stream API end ==");
    }
}
