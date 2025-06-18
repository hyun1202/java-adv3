package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain5 {

    public static void main(String[] args) throws InterruptedException {
        // 병렬 수준 3으로 제한 (공용 풀 제한)
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        // 사용자 요청 풀
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        int nThread = 2;
        for (int i = 1; i <= nThread; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName));
            Thread.sleep(100);
        }
        requestPool.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + "] start");
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 4)
                .parallel()
                .map(i -> HeavyJob.heavyTask(i, requestName))
                .sum();
        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] end, time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
