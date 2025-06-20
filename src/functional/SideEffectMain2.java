package functional;

import java.util.function.Function;

public class SideEffectMain2 {

    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> {
            int result = x * 2;
            // 콘솔에 출력하는 동작이 부수효과이다.
            System.out.println("result = " + result); // 부수효과
            return result;
        };

        func.apply(10);
        func.apply(10);
        func.apply(10);
        func.apply(10);
    }
}
