package java8.section01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

public class Exam02 {

    public static void main(String[] args) {
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        UnaryOperator<Integer> plus10 = (i) -> i+10;
        UnaryOperator<Integer> multiply2 = (i) -> i*2;
        System.out.println(plus10.andThen(multiply2).apply(2));

        run();

        Function<Integer, String> intToString = (i) -> "NUMBER";

        // 객체 생성 방법
        Greeting greeting = new Greeting();

        // 생성자 참조. 서로 다른 생성자를 참조한다.
        Supplier<Greeting> greeting2 = Greeting::new;
        Function<String, Greeting> greeting3 = Greeting::new;

        UnaryOperator<String> hi = (s) -> "hi" + s;
        // 스태틱 메서드 참조
        UnaryOperator<String> hi2 = Greeting::hi; // hi, hi2 출력 결과는 같다

        // 특정 객체의 인스턴스 메서드 참조
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply(" jdragon"));


        String[] names = {"keesun", "whiteship", "toby"};
        // 임의 객체의 인스턴스 메서드 참조
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Arrays.sort(names, String::compareToIgnoreCase);


    }

    private static void run() {
        final int baseNumber = 10;
        // final 생략이 가능하다.Effective final


        // 로컬클래스
        class LocalClass {
            void printBaeNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); //  11 출력
            }
        }

        //익명클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                // 외부의 baseNumber를 참조하지 않는다. 같은 scope 가 아니다.
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(baseNumber);
        };

        // 로컬클래스, 익명클래스와 람다의 다른점
        // 클래스들의 변수들은 쉐도잉이 된다.
        // 로컬클래스와 익명클래스는 각자의 scope 를 가진다.
        // 하지만 람다는 람다를 감싸고 있는 외부와 같은 scope를 가진다. (람다캡처링)
        // 람다는 final 이거나 effective final 변수만 참조할 수 있다.

        printInt.accept(10);
    }
}
