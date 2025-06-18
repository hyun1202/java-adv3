package parallel;

import parallel.forkjoin.SumTask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain3 {

    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("processorCount = " + processorCount + ", commonPool = " + commonPool.getParallelism());
        long startTime = System.currentTimeMillis();

        // 메인 스레드도 작업에 참여한다.
        int sum = IntStream.rangeClosed(1, 8)
                // 공용 ForkJoinPool 사용하여 분할, 처리하고 결과를 join
                .parallel()
                .map(HeavyJob::heavyTask)
                .sum();

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
