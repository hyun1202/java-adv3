package parallel.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain1 {

    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성] " + data);
        long startTime = System.currentTimeMillis();

        // 최대 10개의 스레드를 사용할 수 있는 풀 생성
        // 기본 생성자는 시스템의 프로세서 수에 맞춰 스레드 생성
        ForkJoinPool pool = new ForkJoinPool(10);
        SumTask task = new SumTask(data); // [1~8]

        // 병렬로 합을 구한 후 결과 출력
        // 메인 스레드가 invoke()를 호출하면 SumTask를 스레드 풀에 전달
        // SumTask는 ForkJoinPool에 있는 별도의 스레드에서 실행됨
        Integer result = pool.invoke(task);
        // 풀 종료
        pool.close();

        long endTime = System.currentTimeMillis();

        log("time: " + (endTime - startTime) + "ms, sum: " + result);
        log("pool: " + pool);

    }
}
