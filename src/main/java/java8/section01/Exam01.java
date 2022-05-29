package java8.section01;

import java.util.function.Function;

public class Exam01 {
    public static void main(String[] args) {
        Function<Integer, Integer> plus500 = number -> number + 500;
        Function<Integer, Integer> multiply2 = number -> number * 2;
        System.out.println(plus500.andThen(multiply2).apply(10));
        System.out.println(plus500.compose(multiply2).apply(10));
    }
}
