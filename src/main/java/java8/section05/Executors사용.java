package java8.section05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executors사용 {
    public static void main(String[] args) {
        //sample();
        sample2();
        sample3();
    }

    private static void sample3() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(getRunnable("Hello"),1,2, TimeUnit.SECONDS);
    }

    private static void sample2() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("keesun"));
        executorService.submit(getRunnable("the"));
        executorService.submit(getRunnable("java"));
        executorService.submit(getRunnable("thread"));

        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> {
            System.out.println(message + Thread.currentThread().getName());
        };
    }

    private static void sample() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(getRunnable("Thread "));

        // Gracefully 종료, 현재 진행중인 작업은 마치고 종료한다.
        executorService.shutdown();
        // 그냥 종료시키기
        //executorService.shutdownNow();
    }


}
