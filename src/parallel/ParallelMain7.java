package parallel;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain7 {

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

        List<Future<Integer>> futures = IntStream.range(1, 4)
                .mapToObj(i -> es.submit(() -> HeavyJob.heavyTask(i, requestName)))
                .toList();

        int sum = futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] end, time: " + (endTime - startTime) + "ms, sum: " + sum);

    }
}
