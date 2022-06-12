package java8.section05;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuture두번째 {

    public static void main(String[] args) {

    }

    private static void sample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync( () -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(CompletableFuture두번째::getWorld);
        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync( () -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + "World";
        });
    }

    private static void sample2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync( () -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync( () -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> {
            return h + " " + w;
        });
        System.out.println(future.get());
    }

    private static void sample3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync( () -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync( () -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        List<CompletableFuture<String>> futures = List.of(hello, world);
        CompletableFuture<Void> futuresArray = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> {
                    // thenApply 가 실행될때는 이미 모든 작업이 끝난상태다.
                    // get 은 checked 익셉션 발생
                    // join 은 unchecked 익셉션 발생
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });

        results.get().forEach(System.out::println);

        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world).thenAccept((s) -> {
            System.out.println(s);
        });
        future.get();
    }

    private static void sample4() throws ExecutionException, InterruptedException {
        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            return "Error!!!";
        });
        System.out.println(hello.get());
    }

    private static void sample5() throws ExecutionException, InterruptedException {
        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle( (result, ex) -> {
            if (ex != null)  {
                System.out.println(ex);
                return "ERROR";
            }
            return result;
        });
        System.out.println(hello.get());
    }
}
