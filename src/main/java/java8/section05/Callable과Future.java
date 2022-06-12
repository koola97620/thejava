package java8.section05;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.*;

public class Callable과Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//       sample();
        sample2();
    }

    private static void sample() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () -> {
            Thread.sleep(200);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!!!");

        helloFuture.get();  // 블로킹 콜! 코드대로 실행하다가 get을 만나면 멈추고 결과값을 가져올때까지 기다린다.

        System.out.println(helloFuture.isDone());
        System.out.println("End!!!!");
        executorService.shutdown();
    }

    private static void sample2() throws InterruptedException, ExecutionException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };
        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };
        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "keesun";
        };

//        List<Future<String>> futures = executorService.invokeAll(List.of(hello, java, keesun));
//        for (Future<String> f : futures) {
//            System.out.println(f.get());
//        }

        // 싱글스레드로 하면 Hello 가 출련된다. hello 를 먼저 콜하니까
        // 스레드를 2개로 줘도. hello 가 출력된다.hello 가 끝나야 keesun 이 들어가서 일을 하는데.
        // invokeAny 는 먼저 응답이 오는것을 받기 때문에 Hello 를 받는다.
        // 3개 이상부터는 keesun 을 먼저 받는다.
        String s = executorService.invokeAny(List.of(hello, java, keesun));
        System.out.println(s);

        executorService.shutdown();
    }
}
