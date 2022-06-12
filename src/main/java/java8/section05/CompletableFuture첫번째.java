package java8.section05;

import java.util.Locale;
import java.util.concurrent.*;

public class CompletableFuture첫번째 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // get 을 호출해야 값을 가져올 수 있다.

        //sample();
        //sample2();
        //sample3();
        //sample4();
        sample5();
    }

    private static void sample() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> "hello");
        future.get();
    }

    private static void sample2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("keesun");
        System.out.println(future.get());
    }

    private static void sample3() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        future.get();
    }

    private static void sample4() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(future.get());
    }

    private static void sample5() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply( (s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future.get());
        // ForkJoinPool : Executor 를 구현한 구현체중 하나
    }

    private static void sample6() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenApply( (s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future.get());
        // ForkJoinPool : Executor 를 구현한 구현체중 하나
        // dequeue 사용. 마지막에 들어온게 먼저 나간다. 지정하지 않으면 common pool 사용
        executorService.shutdown();
    }
}
