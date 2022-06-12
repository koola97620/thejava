package java8.section05;

public class Concurrent프로그래밍소개 {
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        System.out.println("Hello: " + Thread.currentThread().getName());
//    }
//
//    static class MyThread extends Thread {
//        @Override
//        public void run() {
//            System.out.println("Thread: " + Thread.currentThread().getName());
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        // 1
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//            }
//        });
        //2번째방법
        Thread thread = new Thread( () ->{
//            Sleep 테스트
//            try {
//                Thread.sleep(1000L);
//            }catch( InterruptedException e) {
//                e.printStackTrace();
//            }

//            Interrupt 테스트
//            while(true) {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("interrupted!");
//                    //return;
//                }
//            }

            // join 테스트
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000L);
            } catch ( InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
//        thread.interrupt();

        thread.join();
        System.out.println(thread + " is finished");
    }
}
