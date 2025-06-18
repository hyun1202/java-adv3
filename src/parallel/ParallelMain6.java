package parallel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain6 {

    public static void main(String[] args) throws InterruptedException {
        // 사용자 요청 풀
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        // 별도의 로직 처리 전용 스레드 풀
        ExecutorService logicPool = Executors.newFixedThreadPool(400);
        int nThread = 20;
        for (int i = 1; i <= nThread; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(100);
        }
        logicPool.close();
        requestPool.close();
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] start");
        long startTime = System.currentTimeMillis();
        Future<Integer> f1 = es.submit(() -> HeavyJob.heavyTask(1, requestName));
        Future<Integer> f2 = es.submit(() -> HeavyJob.heavyTask(2, requestName));
        Future<Integer> f3 = es.submit(() -> HeavyJob.heavyTask(3, requestName));
        Future<Integer> f4 = es.submit(() -> HeavyJob.heavyTask(4, requestName));
        int sum;

        try {
            Integer v1 = f1.get();
            Integer v2 = f2.get();
            Integer v3 = f3.get();
            Integer v4 = f4.get();
            sum = v1 + v2 + v3 + v4;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] end, time: " + (endTime - startTime) + "ms, sum: " + sum);

    }
}
