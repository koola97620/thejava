package java8.section03;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 스트림소개 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

//        Stream<String> stringStream = names.stream().map(String::toUpperCase);
//        names.forEach(System.out::println);

        List<String> collect = names.stream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase(Locale.ROOT);
                }).collect(Collectors.toList());
        // map 과 같은 중개 오퍼레이터로만 구성된 파이프라인은 실행되지 않는다.
        // 종료 오퍼레이터가 실행되지 않으면 중개 오퍼레이터는 무의미하다.
        // 즉 중개오퍼레이터는 lazy 하다.
        // 종료형 오퍼레이터 : collector 추가했을 때 map 이 실행된다.
        collect.forEach(System.out::println);

        // 소스는 변경되지 않는다.
        names.forEach(System.out::println);


        // stream 은 병렬처리가 쉽다
        List<String> collect1 = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("====================");

        // parallel 쓰면 다른 스레드에서 실행한다.
        // parallel 를 쓴다고 무조건 빨라지는건 아니다.
        // 유용할 때 : 데이터가 정말 방대할때!
        List<String> collect2 = names.parallelStream()
                .map(s -> {
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
        collect2.forEach(System.out::println);


    }
}
