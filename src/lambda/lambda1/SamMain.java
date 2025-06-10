package lambda.lambda1;

public class SamMain {
    public static void main(String[] args) {
        SamInterface samInterface = () -> {
            System.out.println("Hello Sam");
        };
        samInterface.run();
    }

    // 함수형 인터페이스가 아니다.
//    NotSamInterface notSamInterface = () -> {
//        System.out.println("not sam");
//    }
}
