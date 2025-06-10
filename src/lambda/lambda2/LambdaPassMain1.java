package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain1 {
    public static void main(String[] args) {
        MyFunction add = (a, b) -> a+b; // 람다 인스턴스 생성
        MyFunction sub = (a, b) -> a-b;

        System.out.println("add.apply(10, 20) = " + add.apply(10, 20));
        System.out.println("add.sub(10, 20) = " + sub.apply(10, 20));

        // 매개변수로 메서드(람다) 전달이 가능하다.
        MyFunction cal = add;   // 람다 참조값을 대입
        System.out.println("cal.apply(10, 20) = " + cal.apply(10, 20));

        cal = sub;
        System.out.println("cal.apply(10, 20) = " + cal.apply(10, 20));
    }
}
